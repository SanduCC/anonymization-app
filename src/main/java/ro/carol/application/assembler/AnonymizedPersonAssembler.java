package ro.carol.application.assembler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.carol.application.entity.AnonymizedPerson;
import ro.carol.application.entity.Person;

import java.util.UUID;
import java.util.function.Supplier;

@Component
@RequiredArgsConstructor
public class AnonymizedPersonAssembler {

    private final Supplier<UUID> uuidSupplier;

    public AnonymizedPerson assemble(Person person, Integer kAnonymity) {
        return AnonymizedPerson.builder()
                .id(uuidSupplier.get())
                .cnp(kAnonymize(person.getCnp(), kAnonymity))
                .varsta(person.getVarsta())
                .codPostal(kAnonymize(person.getCodPostal(), kAnonymity))
                .build();
    }

    private String kAnonymize(String value, Integer k) {
        // Check if the value is already anonymous or null
        if (value == null || value.isEmpty()) {
            return value;
        }

        // Generalize the value by replacing some characters with asterisks
        int generalizationLength = Math.min(k, value.length());

        return "*".repeat(generalizationLength) + value.substring(generalizationLength);
    }

}
