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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        generalizeData(persons);

        // Step 3: Suppression
        suppressData(persons);

        // Step 4: Transformation
        transformData(persons);

        // Step 5: Grouping
        Map<String, List<Person>> groups = groupData(persons);
        int k = 3; // Set the desired k value

        // Step 6: Anonymization
        anonymizeData(groups);

        // Step 7: Validation
        boolean isKAnonymized = validateAnonymization(groups, k);
        log.info("Dataset satisfies k-anonymity: " + isKAnonymized);

        log.info("Saving anonymized persons");
        persons.stream()
                .map(anonymizedPersonAssembler::assemble)
                .forEach(anonymizedPersonRepository::save);
    }

    public List<AnonymizedPerson> retrieveAnonymizedData() {
        log.info("Returning anonymized data");
        return anonymizedPersonRepository.findAll();
    }

    private void generalizeData(List<Person> dataset) {
        for (Person person : dataset) {
            // Generalize relevant attributes, such as age, ZIP code, etc.
            person.setAge(groupAge(person.getAge()));
            person.set(groupZipCode(person.getZipCode()));
            // Generalize other attributes as needed
        }
    }

    private String groupZipCode(String zipCode) {
        // Perform ZIP code generalization based on desired levels of granularity
        return zipCode.substring(0, 3);
    }

    private void suppressData(List<Person> dataset) {
        for (Person person : dataset) {
            // Suppress sensitive attributes, such as names, etc.
            person.setNume("Nume");
            person.setPrenume("Prenume");
            // Suppress other sensitive attributes as needed
        }
    }

    private void transformData(List<Person> dataset) {
        // Implement transformation logic for attributes, if needed
        // Example: Perturb values to protect against re-identification attacks
        // ...
    }

    private Map<String, List<Person>> groupData(List<Person> dataset) {
        Map<String, List<Person>> groups = new HashMap<>();

        for (Person person : dataset) {
            String key = getGroupingKey(person); // Determine the grouping key based on quasi-identifiers

            if (!groups.containsKey(key)) {
                groups.put(key, new ArrayList<>());
            }

            groups.get(key).add(person);
        }

        return groups;
    }

    private void anonymizeData(Map<String, List<Person>> groups) {
        // Implement anonymization logic within each group
        // Example: Shuffle or randomize attribute values
        // ...
    }

    private boolean validateAnonymization(Map<String, List<Person>> groups, int k) {
        for (List<Person> group : groups.values()) {
            if (group.size() < k) {
                return false;
            }
        }

        return true;
    }

    private String getGroupingKey(Person person) {
        // Create a string key based on the quasi-identifiers of the person
        // Example: Combine age, gender, and ZIP code attributes to form the key
        return person.getDataNasterii() + "_"  + person.getAdresa();
    }

}
