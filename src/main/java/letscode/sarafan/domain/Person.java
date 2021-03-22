package letscode.sarafan.domain;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table
@Data
@EqualsAndHashCode(of = { "id" })
public class Person {

    //    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @GeneratedValue
    @JsonView(Views.IdName.class)
    private Long id;

    @JoinColumn(name = "nickname")
    @JsonView(Views.IdName.class)
    private String nickname;

    @JoinColumn(name = "rate")
    @JsonView(Views.FullPerson.class)
    private String rate;

    @JoinColumn(name = "tourney_id")
    @JsonView(Views.FullPerson.class)
    private String tourney_id;

    @JoinColumn(name = "ip_address")
    @JsonView(Views.FullPerson.class)
    private String ip_address;

    @JoinColumn(name = "social_network_1")
    @JsonView(Views.FullPerson.class)
    private String social_network_1;

    @JoinColumn(name = "social_network_2")
    @JsonView(Views.FullPerson.class)
    private String social_network_2;

    @JoinColumn(name = "social_network_3")
    @JsonView(Views.FullPerson.class)
    private String social_network_3;

}