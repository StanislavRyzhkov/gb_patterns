package company.ryzhkov.mvc.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "styles")
public class Style extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @JsonBackReference
    @OneToMany(mappedBy = "style", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Book> books;

    @Override
    public String toString() {
        return name;
    }
}
