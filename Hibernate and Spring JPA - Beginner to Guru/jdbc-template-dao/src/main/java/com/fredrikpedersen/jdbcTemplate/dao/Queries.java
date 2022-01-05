package com.fredrikpedersen.jdbcTemplate.dao;

public class Queries {

    private Queries() {}

    public static final String SELECT_AUTHOR_BY_ID =
            "SELECT * FROM author WHERE id = ?";

    public static final String SELECT_AUTHOR_BY_FIRST_AND_LAST_NAME =
            "SELECT * FROM author WHERE first_name = ? AND last_name = ?";
}
