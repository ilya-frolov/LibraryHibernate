package service.impl;

import lombok.Setter;
import model.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.GenreRepository;
import service.GenreService;

@Setter
@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreRepository genreRepository;

//    public GenreServiceImpl(GenreRepository genreRepository) {
//        this.genreRepository = genreRepository;
//    }

    public void save(Genre genre) {

        if (genreRepository.get(genre) == null) {
            genreRepository.save(genre);
        }
    }

    public Genre get(Genre genre) {
        return genreRepository.get(genre);
    }

//    public boolean isPresent(Genre genre) {
//        if (genreRepository.getByName(genre) != null) {
//            return true;
//        }
//        return false;
//    }

}
