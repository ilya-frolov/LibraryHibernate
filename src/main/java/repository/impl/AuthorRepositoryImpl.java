package repository.impl;

import lombok.NoArgsConstructor;
import lombok.Setter;
import model.Author;
import org.springframework.stereotype.Repository;
import repository.AuthorRepository;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Setter
@Repository
public final class AuthorRepositoryImpl implements AuthorRepository {

    private Set<Author> authors = new HashSet<>();

    public void save(Author author) {
        authors.add(author);
    }

    public Author get(Author author) {
        return authors.stream()
                .filter(a -> a.getName().equals(author.getName()))
                .findFirst().orElse(null);
    }
}

