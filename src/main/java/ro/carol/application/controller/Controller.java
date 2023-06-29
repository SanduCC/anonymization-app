package ro.carol.application.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.carol.application.entity.AnonymizedPerson;
import ro.carol.application.entity.Person;
import ro.carol.application.service.AnonymizationService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/anonymization")
@RequiredArgsConstructor
public class Controller {

    private final AnonymizationService anonymizationService;

    /**
     * Retrieves the original data.
     *
     * @return the list of original persons
     */
    @GetMapping("/original")
    public List<Person> retrieveOriginalData() {
        return anonymizationService.retrieveOriginalData();
    }

    /**
     * Anonymizes the data for a given k-anonymity value.
     *
     * @param kAnonymity the k-anonymity value
     * @return a response entity with a success message
     */
    @PostMapping("/anonymize")
    public ResponseEntity<String> anonymizeData(@RequestParam(name = "k") Integer kAnonymity) {
        anonymizationService.kAnonymity(kAnonymity);
        return ResponseEntity.ok("Data anonymized successfully for k = " + kAnonymity);
    }

    @PostMapping(value = "/anonymize", params = {"k", "l"})
    public ResponseEntity<String> anonymizeData(@RequestParam(name = "k") Integer kAnonymity,
                                                @RequestParam(name = "l") Integer lDiversity) {
        anonymizationService.kAnonymityAndLDiversity(kAnonymity, lDiversity);
        return ResponseEntity.ok("Data anonymized successfully for k = " + kAnonymity + " and l = " + lDiversity);
    }

    /**
     * Retrieves the anonymized data.
     *
     * @return the list of anonymized persons
     */
    @GetMapping("/anonymized")
    public List<AnonymizedPerson> retrieveAnonymizedData() {
        return anonymizationService.retrieveAnonymizedData();
    }

}
