package ro.carol.application.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

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
