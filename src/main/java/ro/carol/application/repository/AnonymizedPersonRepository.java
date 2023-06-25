package ro.carol.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.carol.application.entity.AnonymizedPerson;

import java.util.UUID;

@Repository
public interface AnonymizedPersonRepository extends JpaRepository<AnonymizedPerson, UUID> {
}
