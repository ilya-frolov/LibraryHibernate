package entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
public class Genre {

    @Id
    @GeneratedValue
    private int id;
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "genre")
    Set<Printable> printable = new HashSet();

    public Genre(String name) {
        this.name = name;
    }
}
