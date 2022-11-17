package entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
public class Publisher {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String address;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "publisher")
    Set<Printable> printable = new HashSet();

    public Publisher(String name, String address) {
        this.name = name;
        this.address = address;
    }

}
