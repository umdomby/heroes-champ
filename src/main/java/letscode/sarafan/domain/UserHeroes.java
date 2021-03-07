package letscode.sarafan.domain;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "heroes")
@Data
public class UserHeroes {
    @Id
    @JsonView(Views.IdName.class)
    private String id;

    @JoinColumn(name = "name_heroes")
    @JsonView(Views.FullHeroes.class)
    private String name_heroes;

    @JoinColumn(name = "soc_one")
    @JsonView(Views.FullHeroes.class)
    private String soc_one;

    @JoinColumn(name = "soc_two")
    @JsonView(Views.FullHeroes.class)
    private String soc_two;

    @JoinColumn(name = "soc_three")
    @JsonView(Views.FullHeroes.class)
    private String soc_three;

    @JoinColumn(name = "email")
    @JsonView(Views.FullHeroes.class)
    private String email;

    @JoinColumn(name = "phone")
    @JsonView(Views.FullHeroes.class)
    private String phone;

    @JoinColumn(name = "rate")
    @JsonView(Views.FullHeroes.class)
    private String rate;

    @JoinColumn(name = "tour")
    @JsonView(Views.FullHeroes.class)
    private String tour;

    @JoinColumn(name = "rival")
    @JsonView(Views.FullHeroes.class)
    private String rival;

    @JoinColumn(name = "champ")
    @JsonView(Views.FullHeroes.class)
    private String champ;

    @JoinColumn(name = "win")
    @JsonView(Views.FullHeroes.class)
    private String win;

    @JoinColumn(name = "loss")
    @JsonView(Views.FullHeroes.class)
    private String loss;

}
