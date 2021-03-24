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


//    @JsonView(Views.IdName.class)
//    private String number;

    @JsonView(Views.IdName.class)
    private String name;

//    @Column(updatable = false)
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
//    @JsonView(Views.FullMessage.class)
//    private LocalDateTime date;

    @JsonView(Views.IdName.class)
    private boolean champoff;

//    @JsonView(Views.FullChampionship.class)
//    @OneToMany(
//            mappedBy = "subscriber",
//            orphanRemoval = true
//    )
//    private Set<ChampSubscription> subscriptions = new HashSet<>();
//
//    @JsonView(Views.FullChampionship.class)
//    @OneToMany(
//            mappedBy = "channel",
//            orphanRemoval = true,
//            cascade = CascadeType.ALL
//    )
//    private Set<ChampSubscription> subscribers = new HashSet<>();
}
