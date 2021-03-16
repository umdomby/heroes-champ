package letscode.sarafan.dto;

import com.fasterxml.jackson.annotation.JsonView;
import letscode.sarafan.domain.User;
import letscode.sarafan.domain.Views;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@JsonView(Views.FullUsers.class)
public class UsersDTO {

    private List<User>users;

}
