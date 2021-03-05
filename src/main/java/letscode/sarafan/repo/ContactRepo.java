package letscode.sarafan.repo;

import letscode.sarafan.domain.Contact;
import letscode.sarafan.domain.Message;
import letscode.sarafan.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepo extends JpaRepository<Contact, Long> {
}
