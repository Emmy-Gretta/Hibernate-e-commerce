package rca.ac.rw.mis.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rca.ac.rw.mis.models.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
}
