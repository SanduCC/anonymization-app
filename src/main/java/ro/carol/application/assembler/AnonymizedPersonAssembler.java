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

    private final Random random = new SecureRandom();
    private final Supplier<UUID> uuidSupplier;

    public AnonymizedPerson assemble(Person person) {
        return AnonymizedPerson.builder()
                .id(uuidSupplier.get())
                .nume(person.getNume())
                .prenume(person.getPrenume())
                .cnp(generalizeCNP(person.getCnp()))
                .dataNasterii(generalizeDateOfBirth(person.getDataNasterii()))
                .adresa(generalizeAdresa(person.getAdresa()))
                .telefon(generalizeTelefon(person.getTelefon()))
                .email(generalizeEmail(person.getEmail()))
                .build();
    }

    private String generalizeCNP(String cnp) {
        // For simplicity, generalize the CNP by replacing the last four digits with 'XXXX'
        return cnp.replace(cnp.substring(1,7), "XXXX");
    }

    private static LocalDate generalizeDateOfBirth(LocalDate dateOfBirth) {
        // For simplicity, generalize the date of birth by replacing the year with 'XXXX'
        return LocalDate.of(0, dateOfBirth.getMonth(), dateOfBirth.getDayOfMonth());
    }

    private static String generalizeEmail(String email) {
        // For simplicity, generalize the email by replacing the domain with 'example.com'
        int atIndex = email.indexOf('@');
        String username = email.substring(0, atIndex);
        return username + "@example.com";
    }

    private static String generalizeAdresa(String adresa) {
        // For simplicity, generalize the address by replacing it with 'Generalized Address'
        return "Generalized Address";
    }

    private static String generalizeTelefon(String telefon) {
        // For simplicity, generalize the phone number by replacing the last four digits with 'XXXX'
        return telefon.substring(0, telefon.length() - 4) + "XXXX";
    }

}
