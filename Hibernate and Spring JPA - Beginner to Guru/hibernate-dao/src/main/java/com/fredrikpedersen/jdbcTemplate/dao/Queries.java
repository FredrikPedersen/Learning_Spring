package com.fredrikpedersen.jdbcTemplate.dao;

public class Queries {

    private Queries() {
    }

    public static final String SELECT_AUTHOR_BY_ID =
            "SELECT author.id as id, first_name, last_name, book.id as book_id, book.title, book.isbn, book.publisher " +
            "FROM author " +
            "LEFT OUTER JOIN book ON author.id = book.author_id " +
            "WHERE author.id = ?";

    public static final String SELECT_AUTHOR_BY_FIRST_AND_LAST_NAME =
            "SELECT author.id as id, first_name, last_name, book.id as book_id, book.title, book.isbn, book.publisher " +
            "FROM author " +
            "LEFT OUTER JOIN book ON author.id = book.author_id " +
            "WHERE first_name = ? AND last_name = ?";

    public static final String INSERT_AUTHOR =
            "INSERT INTO author (first_name, last_name) VALUES (?, ?) RETURNING id";

    public static final String UPDATE_AUTHOR =
            "UPDATE author SET first_name = ?, last_name = ? WHERE id = ?";

    public static final String DELETE_AUTHOR_BY_ID =
            "DELETE FROM author WHERE id = ?";

    public static final String SELECT_BOOK_BY_ID =
            "SELECT * FROM book WHERE id = ?";

    public static final String SELECT_BOOK_BY_TITLE =
            "SELECT * FROM book WHERE title = ?";

    public static final String INSERT_BOOK =
            "INSERT INTO book (isbn, publisher, title, author_id) VALUES (?, ?, ?, ?) RETURNING id";

    public static final String UPDATE_BOOK =
            "UPDATE book set isbn = ?, publisher = ?, title = ?, author_id = ? where id = ?";

    public static final String DELETE_BOOK_BY_ID =
            "DELETE FROM book WHERE id = ?";
}
