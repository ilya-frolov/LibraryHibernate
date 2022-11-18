package repository;

import model.Genre;

public interface GenreRepository {

    void save(Genre genre);

    Genre get(Genre genre);

//    Genre getByID(int id);
//
//    Genre getByName(Genre genre);
//
//    Genre add(Genre genre);

}
