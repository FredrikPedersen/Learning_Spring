package com.fredrikpedersen.jdbcTemplate.dao;

public class Queries {

    private Queries() {}

    public static final String SELECT_AUTHOR_BY_ID =
            "SELECT * FROM author WHERE id = ?";

    public static final String SELECT_AUTHOR_BY_FIRST_AND_LAST_NAME =
            "SELECT * FROM author WHERE first_name = ? AND last_name = ?";

    public static final String INSERT_AUTHOR =
            "INSERT INTO author (first_name, last_name) VALUES (?, ?) RETURNING id";

    public static final String UPDATE_AUTHOR =
            "UPDATE author SET first_name = ?, last_name = ? WHERE id = ? RETURNING id";

    public static final String DELETE_AUTHOR_BY_ID =
            "DELETE FROM author WHERE id = ?";
}
