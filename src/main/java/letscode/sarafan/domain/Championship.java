package letscode.sarafan.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@Data
@EqualsAndHashCode(of = { "id" })
public class Championship {

    @Id
    @GeneratedValue
    @JsonView(Views.IdName.class)
    private Long id;

    @JoinColumn(name = "number_champ")
    @JsonView(Views.IdName.class)
    private String number;

    @JoinColumn(name = "type_сhampionship")
    @JsonView(Views.IdName.class)
    private String nameChampionship;

//    @Column(updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonView(Views.FullMessage.class)
    private LocalDateTime startDate;

    @JsonView(Views.FullChampionship.class)
    @OneToMany(
            mappedBy = "subscriber",
            orphanRemoval = true
    )
    private Set<ChampSubscription> subscriptions = new HashSet<>();

    @JsonView(Views.FullChampionship.class)
    @OneToMany(
            mappedBy = "channel",
            orphanRemoval = true,
            cascade = CascadeType.ALL
    )
    private Set<ChampSubscription> subscribers = new HashSet<>();
}
