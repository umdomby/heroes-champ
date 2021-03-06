package letscode.sarafan.service;

import letscode.sarafan.domain.Contact;
import letscode.sarafan.domain.User;
import letscode.sarafan.repo.ContactRepo;
import letscode.sarafan.util.WsSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ContactService {
    private final ContactRepo contactRepo;

    @Autowired
    public ContactService(ContactRepo contactRepo, WsSender wsSender) {
        this.contactRepo = contactRepo;
    }

    public Contact create(Contact contact, User user) {
        contact.setCreationDate(LocalDateTime.now());
        contact.setAuthor(user);
        Contact contactFromDb = contactRepo.save(contact);
        return contactFromDb;
    }
}
