package letscode.sarafan.domain;


import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Championship {

    @Id
    @GeneratedValue
    @JsonView(Views.IdName.class)
    private Long id;

    @JoinColumn(name = "number_champ")
    @JsonView(Views.IdName.class)
    private String number;
}
