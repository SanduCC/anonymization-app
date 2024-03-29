package ro.carol.application.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.carol.application.dto.PersonDto;
import ro.carol.application.entity.AnonymizedPerson;
import ro.carol.application.service.AnonymizationService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/anonymization")
@RequiredArgsConstructor
public class Controller {


    private final AnonymizationService anonymizationService;

    @GetMapping("/original")
    public List<PersonDto> getOriginalData() {
        return anonymizationService.retrieveOriginalData();
    }

    @PostMapping("/anonymized")
    public void anonymizeData() {
        anonymizationService.anonymizeData();
    }

    @GetMapping("/anonymized")
    public List<AnonymizedPerson> retrieveAnonymizedData() {
        return anonymizationService.retrieveAnonymizedData();
    }

}
