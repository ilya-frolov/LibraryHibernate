package com.ilyafrolov.service.impl;

import lombok.Setter;
import com.ilyafrolov.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ilyafrolov.repository.AuthorRepository;
import com.ilyafrolov.service.AuthorService;

@Setter
@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public void save(Author author) {
        if (authorRepository.getByName(author) == null) {
            authorRepository.save(author);
        }
    }

    public Author get(Author author) {
        Author a = new Author();
        return a = authorRepository.getByName(author).stream().findFirst().orElse(null);
    }
}
