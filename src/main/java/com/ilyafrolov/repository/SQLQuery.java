package com.ilyafrolov.repository;

public class SQLQuery {

    public final static String SQL_INSERT_AUTHOR = "insert into authors (name) values (?)";
    public final static String SQL_GET_AUTHOR_BY_NAME = "select id, name from authors where name = ?";
    public final static String SQL_GET_AUTHOR_BY_ID = "select id, name from authors where id = ?";
    public final static String SQL_GET_ALL_AUTHORS = "select id, name from authors";
    public final static String SQL_UPDATE_AUTHOR_BY_ID = "update authors set name = ? where id = ?";
    public final static String SQL_DELETE_AUTHOR_BY_NAME = "delete from authors where name = ?";

    public final static String SQL_INSERT_GENRE = "insert into genres (name) values (?)";
    public final static String SQL_GET_GENRE_BY_NAME = "select id, name from genres where name = ?";
    public final static String SQL_GET_GENRE_BY_ID = "select id, name from genres where id = ?";
    public final static String SQL_GET_ALL_GENRES = "select id, name from genres";
    public final static String SQL_UPDATE_GENRE_BY_ID = "update genres set name = ? where id = ?";
    public final static String SQL_DELETE_GENRE_BY_NAME = "delete from genres where name = ?";


    public final static String SQL_INSERT_BOOK = "insert into books (title, author_id, genre_id) values (?, ?, ?)";
    public final static String SQL_GET_BOOK_BY_NAME = "select id, title, author_id, genre_id from books where title = ?";
    public final static String SQL_GET_ALL_BOOKS = "select id, title, author_id, genre_id from books";
    public final static String SQL_UPDATE_BOOK_BY_NAME = "update books set title = ?, author_id = ?, genre_id = ? " +
            "where id = ?";
    public final static String SQL_DELETE_BOOK_BY_NAME = "delete from books where name = ?";

}
