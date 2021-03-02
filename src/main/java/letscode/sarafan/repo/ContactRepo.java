package letscode.sarafan.repo;

import letscode.sarafan.domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepo extends JpaRepository<Contact, Long> {

}
