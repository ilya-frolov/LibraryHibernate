package com.ilyafrolov.model;

import lombok.*;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Book{

    Integer id;
    String title;
    Author author;
    Genre genre;
//    public Book(Integer id, String title, Author author, Genre genre) {
//        super.setId(id);
//        super.setTitle(title);
//        super.setAuthor(author);
//        super.setGenre(genre);
//    }

    @Override
    public String toString() {
        return "Book{" +
                "id= " + id +
                ", title= " + title +
                ", author= " + author.getName() +
                ", genre= " + genre.getName() +
                "}";
    }

    @Override
    public int hashCode(){
        int hash = 7;
        hash = 31 * hash + id;
        hash = 31 * hash + (title == null ? 0 : title.hashCode());
        hash = 31 * hash + (author.getName() == null ? 0 : author.getName().hashCode());
        hash = 31 * hash + (genre.getName() == null ? 0 : genre.getName().hashCode());
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Book book = (Book) o;
        return id == book.id && Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(genre, book.genre);
    }
}
