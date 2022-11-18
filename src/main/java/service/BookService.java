package service;


import model.Book;

import java.util.List;
import java.util.Set;

public interface BookService {

    void save(Book book);

    Book get(Book book);

    Set<Book> getAll();

    void update(Book book);

    void delete(Book book);
}
