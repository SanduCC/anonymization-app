package ro.carol.application.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PERSON")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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
