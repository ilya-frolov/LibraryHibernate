package model;

import lombok.*;

import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Author {

    private Integer id;
    private String name;

    public Author(String name) {
        this.name = name;
    }

    @Override
    public int hashCode(){
        int hash = 7;
        hash = 31 * hash + id;
        hash = 31 * hash + (name == null ? 0 : name.hashCode());
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Author author = (Author) o;
        return id == author.id && Objects.equals(author, author.name);
    }
}
