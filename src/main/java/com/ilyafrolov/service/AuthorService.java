package com.ilyafrolov.service;

import com.ilyafrolov.model.Author;

import java.util.List;

public interface AuthorService {

    void save(Author author);

    Author get(Author author);
}
