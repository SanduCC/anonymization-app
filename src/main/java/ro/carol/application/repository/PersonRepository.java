package ro.carol.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.carol.application.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {


}
