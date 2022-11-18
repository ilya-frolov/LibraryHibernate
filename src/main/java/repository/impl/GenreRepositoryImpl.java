package repository.impl;

import lombok.Setter;
import model.Genre;
import org.springframework.stereotype.Repository;
import repository.GenreRepository;

import java.util.HashSet;
import java.util.Set;

@Setter
@Repository
public final class GenreRepositoryImpl implements GenreRepository {

    private Set<Genre> genres = new HashSet<>();

    public void save(Genre genre) {
        genres.add(genre);
    }

    public Genre get(Genre genre) {
        return genres.stream()
                .filter(g -> g.getName().equals(genre.getName()))
                .findFirst().orElse(null);
    }
}
