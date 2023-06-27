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

    @GetMapping("/original")
    public List<Person> getOriginalData() {
        return anonymizationService.retrieveOriginalData();
    }

    @PostMapping("/anonymize")
    public ResponseEntity<String> anonymizeData(@RequestParam(name = "k") Integer kAnonymity)
    {
        anonymizationService.anonymizeData(kAnonymity);
        return ResponseEntity.ok("Data anonymized successfully");
    }

    @GetMapping("/anonymized")
    public List<AnonymizedPerson> retrieveAnonymizedData() {
        return anonymizationService.retrieveAnonymizedData();
    }

}
