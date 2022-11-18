package service.impl;

import lombok.Setter;
import model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.BookRepository;
import service.AuthorService;
import service.BookService;
import service.GenreService;
import java.util.Set;

@Setter
@Service
public final class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private GenreService genreService;

//    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService,
//                           GenreService genreService) {
//        this.bookRepository = bookRepository;
//        this.authorService = authorService;
//        this.genreService = genreService;
//    }

    public void save(Book book) {
        if(authorService.get(book.getAuthor()) == null) {
            authorService.save(book.getAuthor());
        }
        if(genreService.get(book.getGenre()) == null) {
            genreService.save(book.getGenre());
        }
        if (bookRepository.get(book) == null) {
            bookRepository.save(book);
        }
    }

    public Book get(Book book) {
        return bookRepository.get(book);
    }

    public Set<Book> getAll() {
        return bookRepository.getAll();
    }

    public void update(Book book) {
        if (get(book) != null) {
            bookRepository.update(book);
        }
    }

    public void delete(Book book) {
        if (get(book) != null) {
            bookRepository.delete(book);
        }
    }
}
