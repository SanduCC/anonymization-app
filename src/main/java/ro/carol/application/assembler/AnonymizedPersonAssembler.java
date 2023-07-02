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

    /**
     * Assembles an {@link AnonymizedPerson} object from a {@link Person} object with k-anonymity applied to sensitive attributes.
     *
     * @param person       the {@link Person} object to be anonymized
     * @param kAnonymity   the number of characters to be replaced with asterisks for k-anonymity
     * @return an {@link AnonymizedPerson} object with k-anonymity applied to sensitive attributes
     */
    public AnonymizedPerson assemble(Person person, Integer kAnonymity) {
        return AnonymizedPerson.builder()
                .id(uuidSupplier.get())
                .cnp(kAnonymize(person.getCnp(), kAnonymity))
                .varsta(person.getVarsta())
                .codPostal(kAnonymize(person.getCodPostal(), kAnonymity))
                .build();
    }


    /**
     * Assembles an {@link AnonymizedPerson} object from a {@link Person} object with k-anonymity and l-diversity applied to
     * sensitive attributes.
     *
     * @param person       the {@link Person} object to be anonymized and diversified
     * @param kAnonymity   the number of characters to be replaced with asterisks for k-anonymity
     * @param lDiversity   the number of diversified values to be generated for l-diversity
     * @return an {@link AnonymizedPerson} object with k-anonymity and l-diversity applied to sensitive attributes
     */
    public AnonymizedPerson assemble(Person person, Integer kAnonymity, Integer lDiversity) {
        return AnonymizedPerson.builder()
                .id(uuidSupplier.get())
                .cnp(kAnonymizeAndLDiversity(person.getCnp(), kAnonymity, lDiversity))
                .varsta(person.getVarsta())
                .codPostal(kAnonymizeAndLDiversity(person.getCodPostal(), kAnonymity, lDiversity))
                .build();
    }

    /**
     * Applies k-anonymity to a given value.
     *
     * @param value the value to be anonymized
     * @param k     the number of characters to be replaced with asterisks for k-anonymity
     * @return an anonymized value
     */
    private String kAnonymize(String value, Integer k) {
        if (value == null || value.isEmpty()) {
            return value;
        }

        int generalizationLength = Math.min(k, value.length());

        return "*".repeat(generalizationLength) + value.substring(generalizationLength);
    }

    /**
     * Applies k-anonymity and l-diversity to a given value.
     *
     * @param value the value to be anonymized and diversified
     * @param k     the number of characters to be replaced with asterisks for k-anonymity
     * @param l     the number of diversified values to be generated for l-diversity
     * @return a diversified and anonymized value
     */
    private String kAnonymizeAndLDiversity(String value, Integer k, Integer l) {
        if (value == null || value.isEmpty()) {
            return value;
        }

        int generalizationLength = Math.min(k, value.length());
        String generalizedValue = "*".repeat(generalizationLength) + value.substring(generalizationLength);

        List<String> diversifiedValues = generateDiversifiedValues(generalizedValue, l);
        int randomIndex = random.get().nextInt(diversifiedValues.size());
        return diversifiedValues.get(randomIndex);
    }


    /**
     * Generates diversified values for a given value by modifying the characters beyond the original length.
     * The original value is also included as one of the diversified values.
     *
     * @param value the original value to be diversified
     * @param l     the number of diversified values to be generated
     * @return a list of diversified values
     */
    private List<String> generateDiversifiedValues(String value, Integer l) {
        List<String> diversifiedValues = new ArrayList<>();
        diversifiedValues.add(value);

        int originalLength = value.length();

        for (int i = originalLength; i < originalLength + l - 1; i++) {
            diversifiedValues.add(value + "*".repeat(i - originalLength));
        }

        return diversifiedValues;
    }
    
}
