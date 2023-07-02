package ro.carol.application.helper.mother;

import ro.carol.application.entity.Person;

public class PersonMother {

    public static Person john() {
        Person person = new Person();
        person.setId(1);
        person.setNume("Smith");
        person.setPrenume("John");
        person.setCnp("1234567890123");
        person.setVarsta(30);
        person.setCodPostal("123456");
        person.setTelefon("0123456789");
        person.setEmail("john.smith@example.com");
        return person;
    }
    
    public static Person michael() {
        Person person = new Person();
        person.setId(2);
        person.setNume("Johnson");
        person.setPrenume("Michael");
        person.setCnp("1345678901234");
        person.setVarsta(50);
        person.setCodPostal("234567");
        person.setTelefon("1234567890");
        person.setEmail("michael.jackson@example.com");
        return person;
    }
    
}
