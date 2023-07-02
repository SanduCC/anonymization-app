package ro.carol.application.helper.mother;

import ro.carol.application.entity.AnonymizedPerson;

import java.util.UUID;

public class AnonymizedPersonMother {

    public static AnonymizedPerson anon1() {
        AnonymizedPerson anonymizedPerson = new AnonymizedPerson();
        anonymizedPerson.setId(UUID.fromString("5a921702-99a1-4303-b36d-52502b79931a"));
        anonymizedPerson.setCnp("1234567890123");
        anonymizedPerson.setVarsta(30);
        anonymizedPerson.setCodPostal("123456");

        return anonymizedPerson;
    }

    public static AnonymizedPerson anon2() {
        AnonymizedPerson anonymizedPerson = new AnonymizedPerson();
        anonymizedPerson.setId(UUID.fromString("8ec63fd4-cd7f-4794-bc7f-0ac59927f3e9"));
        anonymizedPerson.setCnp("1345678901234");
        anonymizedPerson.setVarsta(50);
        anonymizedPerson.setCodPostal("234567");
        return anonymizedPerson;
    }

}
