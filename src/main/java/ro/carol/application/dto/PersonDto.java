package ro.carol.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto {

    private Integer id;
    private String nume;
    private String prenume;
    private String cnp;
    private LocalDate dataNasterii;
    private String email;
    private String adresa;
    private String telefon;

}
