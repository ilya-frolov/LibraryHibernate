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


//    public void add(Book book) {
//
//        if (isPresentTitle(book.getTitle())) {
//            System.out.println("Book(s) with the title " + book.getTitle() + " already exist(s):");
//            System.out.println(bookRepository.getByName(book.getTitle()));
//        }
//
//        if (authorService.isPresent(book.getAuthor())) {
//            book.setAuthor(authorService.get(book.getAuthor()));
//        } else {
//            Author newAuthor = authorRepository.add(book.getAuthor());
//            book.setAuthor(newAuthor);
//        }
//
//        if (genreService.isPresent(book.getGenre())) {
//            book.setGenre(genreService.get(book.getGenre()));
//        } else {
//            Genre newGenre = genreRepository.add(book.getGenre());
//            book.setGenre(newGenre);
//        }
//
//        bookRepository.add(book);
//        System.out.println("The book has been added successfully to the Library.");
//    }
//
//    public void update(Book book) {
//
//        if (isPresentId(book.getId())) {
//            if (authorService.isPresent(book.getAuthor())) {
//                book.setAuthor(authorService.get(book.getAuthor()));
//            } else {
//                Author newAuthor = authorRepository.add(book.getAuthor());
//                book.setAuthor(newAuthor);
//            }
//
//            if (genreService.isPresent(book.getGenre())) {
//                book.setGenre(genreService.get(book.getGenre()));
//            } else {
//                Genre newGenre = genreRepository.add(book.getGenre());
//                book.setGenre(newGenre);
//            }
//
//            bookRepository.update(book);
//            System.out.println("The book has been updated successfully.");
//        } else {
//            System.out.println("The entered id '" + book.getId() + "' doesn't exist!");
//        }
//
//    }
//
//    public void delete(int id) {
//        if (isPresentId(id)) {
//            bookRepository.delete(id);
//            System.out.println("The book has been deleted successfully from the Library.");
//        } else {
//            System.out.println("The entered id '" + id + "' doesn't exist!");
//        }
//
//    }
//
//    public Book get(int id) {
//        Book book = new Book();
//        if (isPresentId(id)) {
//            book = bookRepository.getById(id);
//        } else {
//            System.out.println("The entered id '" + id + "' doesn't exist!");
//        }
//        return book;
//    }
//
//    private boolean isPresentTitle(String title) {
//        if (bookRepository.getByName(title).getTitle() != null) {
//            return true;
//        }
//        return false;
//    }
//
//    private boolean isPresentId(int id) {
//        if (bookRepository.getById(id).getId() != 0) {
//            return true;
//        }
//        return false;
//    }
}
