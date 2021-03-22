package letscode.sarafan.domain;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import javax.persistence.*;

@Entity
@Table
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(Views.Id.class)
    private Long id;

    @JoinColumn(name = "nickname")
    @JsonView(Views.IdName.class)
    private String nickname;

    @JoinColumn(name = "rate")
    @JsonView(Views.FullHeroes.class)
    private String rate;

    @JoinColumn(name = "tourney_id")
    @JsonView(Views.FullHeroes.class)
    private String tourney_id;

    @JoinColumn(name = "ip_address")
    @JsonView(Views.FullHeroes.class)
    private String ip_address;

    @JoinColumn(name = "social_network_1")
    @JsonView(Views.FullHeroes.class)
    private String social_network_1;

    @JoinColumn(name = "social_network_2")
    @JsonView(Views.FullHeroes.class)
    private String social_network_2;

    @JoinColumn(name = "social_network_3")
    @JsonView(Views.FullHeroes.class)
    private String social_network_3;

}