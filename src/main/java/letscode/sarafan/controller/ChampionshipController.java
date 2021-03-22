package letscode.sarafan.controller;

import com.fasterxml.jackson.annotation.JsonView;
import letscode.sarafan.domain.Person;
import letscode.sarafan.domain.Views;
import letscode.sarafan.dto.EventType;
import letscode.sarafan.dto.ObjectType;
import letscode.sarafan.repo.PersonRepo;
import letscode.sarafan.util.WsSender;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.BiConsumer;

@RestController
@RequestMapping("championship")
public class ChampionshipController {
    private final PersonRepo personRepo;
    private final BiConsumer<EventType, Person> wsSender;

    @Autowired
    public ChampionshipController(PersonRepo personRepo, WsSender wsSender) {
        this.personRepo = personRepo;
        this.wsSender = wsSender.getSender(ObjectType.PERSON, Views.IdName.class);
    }

    @GetMapping
    @JsonView(Views.IdName.class)
    public List<Person> list() {
        return personRepo.findAll();
    }

    @GetMapping("{id}")
    @JsonView(Views.FullPerson.class)
    public Person getOne(@PathVariable("id") Person person) {
        return person;
    }

    @PostMapping
    public Person create(@RequestBody Person person) {
        Person updatedPerson = personRepo.save(person);
        wsSender.accept(EventType.CREATE, updatedPerson);
        return updatedPerson;
    }

    @PutMapping("{id}")
    public Person update(
            @PathVariable("id") Person personFromDb,
            @RequestBody Person person
    ) {
        BeanUtils.copyProperties(person, personFromDb, "id");
        Person updatedPerson = personRepo.save(personFromDb);
        wsSender.accept(EventType.UPDATE, updatedPerson);
        return updatedPerson;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Person person) {
        personRepo.delete(person);
        wsSender.accept(EventType.REMOVE, person);
    }
}
