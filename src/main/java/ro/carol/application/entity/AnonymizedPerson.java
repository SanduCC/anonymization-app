package ro.carol.application.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Table(name = "ANONYMIZED_PERSON")
public class AnonymizedPerson {

    @Id
    private UUID id;

    @Column
    private String nume;

    @Column
    private String prenume;

    @Column
    private String cnp;

    @Column
    private LocalDate dataNasterii;

    @Column
    private String email;

    @Column
    private String adresa;

    @Column
    private String telefon;

}
