package letscode.sarafan.controller;

import com.fasterxml.jackson.annotation.JsonView;
import letscode.sarafan.domain.Champ;
import letscode.sarafan.domain.Views;
import letscode.sarafan.dto.EventType;
import letscode.sarafan.dto.ObjectType;
import letscode.sarafan.repo.ChampRepo;
import letscode.sarafan.util.WsSender;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.BiConsumer;

@RestController
@RequestMapping("champ")
public class ChampController {
    private final ChampRepo champRepo;
    private final BiConsumer<EventType, Champ> wsSender;

    @Autowired
    public ChampController(ChampRepo champRepo, WsSender wsSender) {
        this.champRepo = champRepo;
        this.wsSender = wsSender.getSender(ObjectType.CHAMP, Views.IdName.class);
    }

    @GetMapping
    @JsonView(Views.IdName.class)
    public List<Champ> list() {
        return champRepo.findAll();
    }

    @GetMapping("{id}")
    @JsonView(Views.FullChamp.class)
    public Champ getOne(@PathVariable("id") Champ champ) {
        return champ;
    }

    @PostMapping
    public Champ create(@RequestBody Champ champ) {
        champ.setCreationDate(LocalDateTime.now());
        Champ updatedChamp = champRepo.save(champ);
        wsSender.accept(EventType.CREATE, updatedChamp);
        return updatedChamp;
    }

    @PutMapping("{id}")
    public Champ update(
            @PathVariable("id") Champ champFromDb,
            @RequestBody Champ champ
    ) {
        BeanUtils.copyProperties(champ, champFromDb, "id");
        Champ updatedChamp = champRepo.save(champFromDb);
        wsSender.accept(EventType.UPDATE, updatedChamp);
        return updatedChamp;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Champ champ) {
        champRepo.delete(champ);
        wsSender.accept(EventType.REMOVE, champ);
    }
}
