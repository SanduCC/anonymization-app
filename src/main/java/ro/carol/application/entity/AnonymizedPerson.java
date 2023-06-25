package ro.carol.application.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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

    @Column(name = "NUME")
    private String nume;

    @Column(name = "PRENUME")
    private String prenume;

    @Column(name = "CNP")
    private String cnp;

    @Column(name = "VARSTA")
    private Integer varsta;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "COD_POSTAL")
    private String codPostal;

    @Column(name = "TELEFON")
    private String telefon;

}
