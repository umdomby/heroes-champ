package letscode.sarafan.controller;

import com.fasterxml.jackson.annotation.JsonView;
import letscode.sarafan.domain.Championship;
import letscode.sarafan.domain.Views;
import letscode.sarafan.dto.EventType;
import letscode.sarafan.dto.ObjectType;
import letscode.sarafan.repo.ChampionshipRepo;
import letscode.sarafan.util.WsSender;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.BiConsumer;

@RestController
@RequestMapping("championship")
public class ChampionshipController {
    private final ChampionshipRepo championshipRepo;
    private final BiConsumer<EventType, Championship> wsSender;

    @Autowired
    public ChampionshipController(ChampionshipRepo championshipRepo, WsSender wsSender) {
        this.championshipRepo = championshipRepo;
        this.wsSender = wsSender.getSender(ObjectType.CHAMPIONSHIP, Views.IdName.class);
    }

    @GetMapping
    @JsonView(Views.IdName.class)
    public List<Championship> list() {
        return championshipRepo.findAll();
    }

    @GetMapping("{id}")
    @JsonView(Views.FullChampionship.class)
    public Championship getOne(@PathVariable("id") Championship championship) {
        return championship;
    }

    @PostMapping
    public Championship create(@RequestBody Championship championship) {
        Championship updatedChampionship = championshipRepo.save(championship);
        wsSender.accept(EventType.CREATE, updatedChampionship);
        return updatedChampionship;
    }

    @PutMapping("{id}")
    public Championship update(
            @PathVariable("id") Championship championshipFromDb,
            @RequestBody Championship championship
    ) {
        BeanUtils.copyProperties(championship, championshipFromDb, "id");
        Championship updatedChampionship = championshipRepo.save(championshipFromDb);
        wsSender.accept(EventType.UPDATE, updatedChampionship);
        return updatedChampionship;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Championship championship) {
        championshipRepo.delete(championship);
        wsSender.accept(EventType.REMOVE, championship);
    }
}
