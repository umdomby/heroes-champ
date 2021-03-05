package letscode.sarafan.controller;

import com.fasterxml.jackson.annotation.JsonView;
import letscode.sarafan.domain.Contact;
import letscode.sarafan.domain.Views;
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
    @JsonView(Views.IdName.class)
    public List<Contact> list() {
        return contactRepo.findAll();
    }

    @GetMapping("{id}")
    @JsonView(Views.FullContact.class)
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
