package repository.impl;

import lombok.Setter;
import model.Book;
import org.springframework.stereotype.Repository;
import repository.BookRepository;

import java.util.HashSet;
import java.util.Set;

@Setter
@Repository
public final class BookRepositoryImpl implements BookRepository {

    private Set<Book> books = new HashSet<>();

    public void save(Book book) {
        books.add(book);
    }

    public Book get(Book book) {
        return books.stream()
                .filter(b -> b.getTitle().equals(book.getTitle()))
                .findFirst().orElse(null);
    }

    public Set<Book> getAll() {
        return books;
    }

    //change to stream
    public void update(Book book) {
        for (Book b : books) {
            if (b.getTitle().equals(book.getTitle())) {
                b.setTitle(book.getTitle());
                b.setAuthor(book.getAuthor());
                b.setGenre(book.getGenre());
            }
        }
    }

    //change to stream
    public void delete(Book book) {
        for (Book b : books) {
            if (b.getTitle().equals(book.getTitle())) {
                books.remove(b);
            }
        }
    }
}
