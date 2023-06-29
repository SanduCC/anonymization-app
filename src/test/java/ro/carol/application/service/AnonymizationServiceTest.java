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
import ro.carol.application.helper.mother.PersonMother;
import ro.carol.application.repository.AnonymizedPersonRepository;
import ro.carol.application.repository.PersonRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

    @BeforeEach
    void setUp() {
        persons.add(PersonMother.john());
        persons.add(PersonMother.michael());
    }

    @Test
    void retrieveOriginalData() {
        // given
        when(personRepository.findAll()).thenReturn(persons);

        // when
        List<Person> result = anonymizationService.retrieveOriginalData();

        // then
        assertEquals(persons, result);
        verify(personRepository).findAll();
    }

    @Test
    void anonymizeData() {
        // given
        when(personRepository.findAll()).thenReturn(persons);

        AnonymizedPerson anonymizedPerson1 = new AnonymizedPerson("John", "Doe", "johndoe@example.com");
        AnonymizedPerson anonymizedPerson2 = new AnonymizedPerson("Jane", "Doe", "janedoe@example.com");
        when(anonymizedPersonAssembler.assemble(any(Person.class), anyInt())).thenReturn(anonymizedPerson1, anonymizedPerson2);

        // when
        anonymizationService.kAnonymity(2);

        // then
        verify(personRepository, times(1)).findAll();
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
        assertEquals(anonymizedPersons, result);
        verify(anonymizedPersonRepository, times(1)).findAll();
    }
}