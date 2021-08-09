package com.fredrikpedersen.brewery.security.permissions;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 09/08/2021 at 16:57
 */
public final class Authorities {

    private Authorities() {}

    public static final String BEER_CREATE = "beer.create";
    public static final String BEER_UPDATE = "beer.update";
    public static final String BEER_READ = "beer.read";
    public static final String BEER_DELETE = "beer.delete";

    public static final String CUSTOMER_CREATE = "customer.create";
    public static final String CUSTOMER_UPDATE = "customer.update";
    public static final String CUSTOMER_READ = "customer.read";
    public static final String CUSTOMER_DELETE = "customer.delete";

    public static final String BREWERY_CREATE = "brewery.create";
    public static final String BREWERY_UPDATE = "brewery.update";
    public static final String BREWERY_READ = "brewery.read";
    public static final String BREWERY_DELETE = "brewery.delete";
}
