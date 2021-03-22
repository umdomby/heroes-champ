package letscode.sarafan.repo;

import letscode.sarafan.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepo extends JpaRepository<Person, Long> {

}
