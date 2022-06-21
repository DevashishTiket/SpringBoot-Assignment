package mongotest.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString

@Document(collection="Book")
public class BookM {
    @Id
    private int id;
    private String bookName;
    private String customerName;
    private String review;
}
