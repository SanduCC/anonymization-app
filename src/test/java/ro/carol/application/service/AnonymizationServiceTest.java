package ro.carol.application.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ro.carol.application.assembler.AnonymizedPersonAssembler;
import ro.carol.application.entity.AnonymizedPerson;
import ro.carol.application.entity.Person;
import ro.carol.application.helper.mother.AnonymizedPersonMother;
import ro.carol.application.helper.mother.PersonMother;
import ro.carol.application.repository.AnonymizedPersonRepository;
import ro.carol.application.repository.PersonRepository;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AnonymizationServiceTest {

    @Mock
    private PersonRepository personRepository;

    @Mock
    private AnonymizedPersonAssembler anonymizedPersonAssembler;

    @Mock
    private AnonymizedPersonRepository anonymizedPersonRepository;

    @InjectMocks
    private AnonymizationService anonymizationService;

    private final List<Person> persons = new ArrayList<>();
    private final List<AnonymizedPerson> anonymizedPersons = new ArrayList<>();

    @BeforeEach
    void setUp() {
        persons.add(PersonMother.john());
        persons.add(PersonMother.michael());
        anonymizedPersons.add(AnonymizedPersonMother.anon1());
        anonymizedPersons.add(AnonymizedPersonMother.anon2());
    }

    @Test
    void retrieveOriginalData() {
        // given
        when(personRepository.findAll()).thenReturn(persons);

        // when
        List<Person> result = anonymizationService.retrieveOriginalData();

        // then
        assertThat(persons).isEqualTo(result);
        verify(personRepository).findAll();
    }

    @Test
    void anonymizeData() {
        // given
        when(personRepository.findAll()).thenReturn(persons);
        when(anonymizedPersonAssembler.assemble(persons.get(0), 3)).thenReturn(anonymizedPersons.get(0));
        when(anonymizedPersonAssembler.assemble(persons.get(1), 3)).thenReturn(anonymizedPersons.get(1));

        // when
        anonymizationService.kAnonymity(3);

        // then
        verify(personRepository).findAll();
        verify(anonymizedPersonAssembler, times(2)).assemble(any(Person.class), anyInt());
        verify(anonymizedPersonRepository, times(2)).save(any(AnonymizedPerson.class));
    }

    @Test
    void retrieveAnonymizedData() {
        // given
        when(anonymizedPersonRepository.findAll()).thenReturn(anonymizedPersons);

        // when
        List<AnonymizedPerson> result = anonymizationService.retrieveAnonymizedData();

        // then
        assertThat(anonymizedPersons).isEqualTo(result);
        verify(anonymizedPersonRepository, times(1)).findAll();
    }

}