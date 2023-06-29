package ro.carol.application.assembler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.carol.application.entity.AnonymizedPerson;
import ro.carol.application.entity.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.function.Supplier;

@Component
@RequiredArgsConstructor
public class AnonymizedPersonAssembler {

    private final Supplier<UUID> uuidSupplier;
    private final Supplier<Random> random;

    public AnonymizedPerson assemble(Person person, Integer kAnonymity) {
        return AnonymizedPerson.builder()
                .id(uuidSupplier.get())
                .cnp(kAnonymize(person.getCnp(), kAnonymity))
                .varsta(person.getVarsta())
                .codPostal(kAnonymize(person.getCodPostal(), kAnonymity))
                .build();
    }

    public AnonymizedPerson assemble(Person person, Integer kAnonymity, Integer lDiversity) {
        return AnonymizedPerson.builder()
                .id(uuidSupplier.get())
                .cnp(kAnonymize(person.getCnp(), kAnonymity, lDiversity))
                .varsta(person.getVarsta())
                .codPostal(kAnonymize(person.getCodPostal(), kAnonymity, lDiversity))
                .build();
    }

    private String kAnonymize(String value, Integer k) {
        // Check if the value is already anonymous or null
        if (value == null || value.isEmpty()) {
            return value;
        }

        // Generalize the value by replacing first k characters with asterisks
        int generalizationLength = Math.min(k, value.length());

        return "*".repeat(generalizationLength) + value.substring(generalizationLength);
    }

    private String kAnonymize(String value, Integer k, Integer l) {
        // Check if the value is already anonymous or null
        if (value == null || value.isEmpty()) {
            return value;
        }

        // Generalize the value by replacing first k characters with asterisks
        int generalizationLength = Math.min(k, value.length());
        String generalizedValue = "*".repeat(generalizationLength) + value.substring(generalizationLength);

        // Diversify the sensitive attribute
        List<String> diversifiedValues = generateDiversifiedValues(generalizedValue, l);
        int randomIndex = random.get().nextInt(diversifiedValues.size());
        return diversifiedValues.get(randomIndex);
    }

    private List<String> generateDiversifiedValues(String value, Integer l) {
        List<String> diversifiedValues = new ArrayList<>();

        // Add the original value as one of the diversified values
        diversifiedValues.add(value);

        // Generate additional diversified values by modifying the characters beyond the original length
        int originalLength = value.length();

        for (int i = originalLength; i < originalLength + l - 1; i++) {
            diversifiedValues.add(value + "*".repeat(i - originalLength));
        }

        return diversifiedValues;
    }
}
