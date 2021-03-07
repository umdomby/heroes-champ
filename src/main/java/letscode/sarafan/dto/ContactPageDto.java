package letscode.sarafan.dto;

import com.fasterxml.jackson.annotation.JsonView;
import letscode.sarafan.domain.Contact;
import letscode.sarafan.domain.Views;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@JsonView(Views.FullContact.class)
public class ContactPageDto {
    private List<Contact> contacts;
    private int currentPage;
    private int totalPages;
}
