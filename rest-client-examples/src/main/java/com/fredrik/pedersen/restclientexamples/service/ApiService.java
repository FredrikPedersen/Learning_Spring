package com.fredrik.pedersen.restclientexamples.service;

import com.fredrik.pedersen.api.domain.User;

import java.util.List;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 13/02/2020 at 22:05
 */

public interface ApiService {

    List<User> getUsers(Integer limit);

}
