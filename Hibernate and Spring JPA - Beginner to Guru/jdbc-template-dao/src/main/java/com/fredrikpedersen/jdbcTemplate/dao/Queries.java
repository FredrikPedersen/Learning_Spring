package com.fredrikpedersen.jdbcTemplate.dao;

public class Queries {

    private Queries() {}

    public static final String SELECT_AUTHOR_BY_ID = "SELECT * FROM author WHERE id = ?";
}
