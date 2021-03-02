package letscode.sarafan.controller;
import letscode.sarafan.domain.Contact;
import letscode.sarafan.repo.ContactRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("contact")
public class ContactController {

    private final ContactRepo contactRepo;

    @Autowired
    public ContactController(ContactRepo contactRepo) {
        this.contactRepo = contactRepo;
    }

    @GetMapping
    public List<Contact> list() {
        return contactRepo.findAll();
    }

    @GetMapping("{id}")
    public Contact getOne(@PathVariable("id") Contact contact) {
        return contact;
    }

    @PostMapping
    public Contact create(@RequestBody Contact contact) {
        contact.setCreationDate(LocalDateTime.now());
        return contactRepo.save(contact);
    }

    @PutMapping("{id}")
    public Contact update(
            @PathVariable("id") Contact contactFromDb,
            @RequestBody Contact contact
    ) {
        BeanUtils.copyProperties(contact, contactFromDb, "id");

        return contactRepo.save(contactFromDb);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Contact contact) {
        contactRepo.delete(contact);
    }

}
