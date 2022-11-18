package service;


import model.Author;

public interface AuthorService {

    void save(Author author);

    Author get(Author author);

}
