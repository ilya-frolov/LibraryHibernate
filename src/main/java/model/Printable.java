package model;

import lombok.Data;

@Data
public abstract class Printable {

    private Integer id;
    private String title;
    private Author author;
    private Genre genre;
}
