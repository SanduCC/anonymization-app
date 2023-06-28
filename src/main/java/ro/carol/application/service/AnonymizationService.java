package ro.carol.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ro.carol.application.assembler.AnonymizedPersonAssembler;
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
    private final AnonymizedPersonAssembler anonymizedPersonAssembler;
    private final AnonymizedPersonRepository anonymizedPersonRepository;


    /**
     * Retrieves all the original data from the "person" table.
     *
     * @return a list of {@link Person} objects representing the original data
     */
    public List<Person> retrieveOriginalData() {
        var persons = personRepository.findAll();
        log.info("Returning original data");
        return persons;
    }

    /**
     * Anonymizes the data from the "person" table and saves it to the "anonymized_person" table.
     *
     * @param kAnonymity the k-anonymity parameter used for anonymization
     */
    public void anonymizeData(Integer kAnonymity) {
        // Retrieve all records from the "person" table
        List<Person> persons = personRepository.findAll();

        // Anonymize each person record and save it to the "anonymized_person" table
        persons.forEach(person -> {
            var anonymizedPerson = anonymizedPersonAssembler.assemble(person, kAnonymity);
            log.info("Saving anonymized person data");
            anonymizedPersonRepository.save(anonymizedPerson);
        });
    }

    /**
     * Retrieves all the anonymized data from the "anonymized_person" table.
     *
     * @return a list of {@link AnonymizedPerson} objects representing the anonymized data
     */
    public List<AnonymizedPerson> retrieveAnonymizedData() {
        log.info("Returning anonymized data");
        return anonymizedPersonRepository.findAll();
    }

}
