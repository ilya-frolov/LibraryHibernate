package service;

import model.Genre;

public interface GenreService {

    void save(Genre genre);

    Genre get(Genre genre);
//    boolean isPresent(Genre genre);

}
