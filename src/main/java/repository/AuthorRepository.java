package repository;


import model.Author;

public interface AuthorRepository {

    void save(Author author);

    Author get(Author author);

//    Author getByID(int id);
//
//    Author getByName(Author author);
//
//    Author add(Author author);

}
