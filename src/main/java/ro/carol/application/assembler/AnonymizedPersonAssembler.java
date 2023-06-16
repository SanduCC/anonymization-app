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

    private static final double EPSILON = 1.0; // Privacy budget
    private static final double SENSITIVITY = 1.0; // Sensitivity of the field

    private final Random random = new SecureRandom();
    private final Supplier<UUID> uuidSupplier;

    public AnonymizedPerson assemble(Person person) {
        return AnonymizedPerson.builder()
                .id(uuidSupplier.get())
                .nume(addNoise(person.getNume()))
                .prenume(addNoise(person.getPrenume()))
                .cnp(addNoise(person.getCnp()))
                .dataNasterii(addNoise(person.getDataNasterii()))
                .adresa(addNoise(person.getAdresa()))
                .telefon(addNoise(person.getTelefon()))
                .email(addNoise(person.getEmail()))
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

    private LocalDate addNoise(LocalDate value) {
        if (value == null) {
            return null;
        }
        double scale = SENSITIVITY / EPSILON;
        double noise = laplaceMechanism(scale);
        return value.plusDays((long) noise);
    }

    private double laplaceMechanism(double scale) {
        double uniform = random.nextDouble() - 0.5; // Uniform random number between -0.5 and 0.5
        double laplace = -Math.signum(uniform) * Math.log(1 - 2 * Math.abs(uniform));
        return scale * laplace;
    }

}
