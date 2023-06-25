package ro.carol.application.assembler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.carol.application.entity.AnonymizedPerson;
import ro.carol.application.entity.Person;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;
import java.util.function.Supplier;

@Component
@RequiredArgsConstructor
public class AnonymizedPersonAssembler {

    private static final double EPSILON = 0.1; // Privacy budget
    private static final double SENSITIVITY = 1.0; // Sensitivity of the field
    private static final double SCALE = SENSITIVITY / EPSILON;

    private final Random random = new SecureRandom();
    private final Supplier<UUID> uuidSupplier;

    public AnonymizedPerson assemble(Person person) {
        return AnonymizedPerson.builder()
                .id(uuidSupplier.get())
                .nume(person.getNume())
                .prenume(person.getPrenume())
                .cnp(addNoise(person.getCnp()))
                .varsta(addNoise(person.getVarsta())) //replace or add age
                .codPostal(addNoise(person.getCodPostal()))
                .telefon(addNoise(person.getTelefon()))
                .email(person.getEmail())
                .build();
    }

    private String addNoise(String value) {
        if (value == null || value.isEmpty()) {
            return value;
        }
        double scale = SENSITIVITY / EPSILON;
        double noise = laplaceMechanism(scale);
        int originalLength = value.length();
        int anonymizedLength = originalLength + (int) noise;
        if (anonymizedLength <= 0) {
            return "";
        } else if (anonymizedLength >= originalLength) {
            return value;
        } else {
            return value.substring(0, anonymizedLength);
        }
    }

    public int addNoise(int originalValue) {
        // Generate a random noise sample from the Laplace distribution
        double laplaceNoise = laplaceMechanism(SCALE);

        // Add the noise to the original value
        double noisyValue = originalValue + (laplaceNoise / SCALE);

        // Round the noisy value to the nearest integer

        return (int) Math.round(noisyValue);
    }

    private LocalDate addNoise(LocalDate value) {
        if (value == null) {
            return null;
        }
        double noise = laplaceMechanism(SCALE);
        return value.plusDays((long) noise);
    }

    private double laplaceMechanism(double scale) {
        double uniform = random.nextDouble() - 0.5; // Uniform random number between -0.5 and 0.5
        double laplace = -Math.signum(uniform) * Math.log(1 - 2 * Math.abs(uniform));
        return scale * laplace;
    }

}
