package service.impl;

import lombok.Setter;
import model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AuthorRepository;
import service.AuthorService;

@Setter
@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

//    public AuthorServiceImpl(AuthorRepository authorRepository) {
//        this.authorRepository = authorRepository;
//    }

    public void save(Author author) {
        if (authorRepository.get(author) == null) {
            authorRepository.save(author);
        }
    }

    public Author get(Author author) {
        return authorRepository.get(author);
    }

//    public boolean isPresent(Author author) {
//        if (authorRepository.getByName(author) != null) {
//            return true;
//        }
//        return false;
//    }

}
