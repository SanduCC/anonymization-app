package ro.carol.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ro.carol.application.assembler.AnonymizedPersonAssembler;
import ro.carol.application.assembler.PersonDtoAssembler;
import ro.carol.application.dto.PersonDto;
import ro.carol.application.entity.AnonymizedPerson;
import ro.carol.application.entity.Person;
import ro.carol.application.repository.AnonymizedPersonRepository;
import ro.carol.application.repository.PersonRepository;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class AnonymizationService {


    private final PersonRepository personRepository;
    private final PersonDtoAssembler personDtoAssembler;
    private final AnonymizedPersonAssembler anonymizedPersonAssembler;
    private final AnonymizedPersonRepository anonymizedPersonRepository;

    public List<PersonDto> retrieveOriginalData() {
        var persons = personRepository.findAll();
        log.info("Returning original data");
        return persons.stream().map(personDtoAssembler::toDto).toList();
    }

    public void anonymizeData() {
        // Retrieve all records from the "person" table
        List<Person> persons = personRepository.findAll();

        // Anonymize each person record and save it to the "anonymized_person" table
        for (Person person : persons) {
            AnonymizedPerson anonymizedPerson = anonymizedPersonAssembler.assemble(person);
            anonymizedPersonRepository.save(anonymizedPerson);
        }
    }

    public List<AnonymizedPerson> retrieveAnonymizedData() {
        return anonymizedPersonRepository.findAll();
    }

}
