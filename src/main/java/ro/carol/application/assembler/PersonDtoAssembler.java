package ro.carol.application.assembler;

import org.springframework.stereotype.Component;
import ro.carol.application.dto.PersonDto;
import ro.carol.application.entity.Person;

@Component
public class PersonDtoAssembler {

    public PersonDto toDto(Person person){
        return PersonDto.builder()
                .id(person.getId())
                .nume(person.getNume())
                .prenume(person.getPrenume())
                .cnp(person.getCnp())
                .dataNasterii(person.getDataNasterii())
                .email(person.getEmail())
                .adresa(person.getAdresa())
                .telefon(person.getTelefon())
                .build();
    }

}
