package repository;

import model.Book;

import java.util.List;
import java.util.Set;

public interface BookRepository {

    void save(Book book);

    Book get(Book book);

    Set<Book> getAll();

    void update(Book book);

    void delete(Book book);

//    List<Book> getAll();

//    int add(Book book);
//
//    int update(Book book);
//
//    int delete(int id);
//
//    Book getById(int id);
//
//    Book getByName(String title);
}
