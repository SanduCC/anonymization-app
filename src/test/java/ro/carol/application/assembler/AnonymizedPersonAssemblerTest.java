package ro.carol.application.assembler;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import ro.carol.application.entity.AnonymizedPerson;
import ro.carol.application.entity.Person;
import ro.carol.application.helper.mother.PersonMother;

import java.util.Random;
import java.util.UUID;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class AnonymizedPersonAssemblerTest {

    private AnonymizedPersonAssembler anonymizedPersonAssembler;

    private final Supplier<UUID> uuidSupplier = () -> UUID.fromString("5a921702-99a1-4303-b36d-52502b79931a");

    private final Supplier<Random> randomSupplier = () -> new Random(0);

    @BeforeEach
    void setUp() {
        anonymizedPersonAssembler = new AnonymizedPersonAssembler(uuidSupplier, randomSupplier);
    }

    @Test
    void testAssembleWithKAnonymity() {
        Person person = PersonMother.john();
        Integer kAnonymity = 5;

        AnonymizedPerson anonymizedPerson = anonymizedPersonAssembler.assemble(person, kAnonymity);

        assertThat(person.getCnp()).isNotEqualTo(anonymizedPerson.getCnp());
        assertThat(person.getCodPostal()).isNotEqualTo(anonymizedPerson.getCodPostal());
        assertThat(person.getVarsta()).isEqualTo(anonymizedPerson.getVarsta());
    }

    @Test
    void testAssembleWithKAnonymityAndLDiversity() {
        Person person = PersonMother.john();
        Integer kAnonymity = 5;
        Integer lDiversity = 3;

        AnonymizedPerson anonymizedPerson = anonymizedPersonAssembler.assemble(person, kAnonymity, lDiversity);

        assertThat(person.getCnp()).isNotEqualTo(anonymizedPerson.getCnp());
        assertThat(person.getCodPostal()).isNotEqualTo(anonymizedPerson.getCodPostal());
        assertThat(person.getVarsta()).isEqualTo(anonymizedPerson.getVarsta());
    }

}