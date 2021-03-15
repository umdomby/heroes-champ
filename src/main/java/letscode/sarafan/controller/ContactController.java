package letscode.sarafan.controller;

import com.fasterxml.jackson.annotation.JsonView;
import letscode.sarafan.domain.Contact;
import letscode.sarafan.domain.Views;
import letscode.sarafan.dto.EventType;
import letscode.sarafan.dto.ObjectType;
import letscode.sarafan.repo.ContactRepo;
import letscode.sarafan.util.WsSender;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.BiConsumer;

@RestController
@RequestMapping("contact")
public class ContactController {
    private final ContactRepo contactRepo;
    private final BiConsumer<EventType, Contact> wsSender;

    @Autowired
    public ContactController(ContactRepo contactRepo, WsSender wsSender) {
        this.contactRepo = contactRepo;
        this.wsSender = wsSender.getSender(ObjectType.CONTACT, Views.IdName.class);
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
        Contact updatedContact = contactRepo.save(contact);

        wsSender.accept(EventType.CREATE, updatedContact);

        return updatedContact;
    }

    @PutMapping("{id}")
    public Contact update(
            @PathVariable("id") Contact contactFromDb,
            @RequestBody Contact contact
    ) {
        BeanUtils.copyProperties(contact, contactFromDb, "id");

        Contact updatedContact = contactRepo.save(contactFromDb);

        wsSender.accept(EventType.UPDATE, updatedContact);

        return updatedContact;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Contact contact) {
        contactRepo.delete(contact);
        wsSender.accept(EventType.REMOVE, contact);
    }
}
