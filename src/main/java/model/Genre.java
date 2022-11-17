package model;

import lombok.*;

import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Genre {

    private Integer id;
    private String name;

    public Genre(String name) {
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
        Genre genre = (Genre) o;
        return id == genre.id && Objects.equals(genre, genre.name);
    }
}
