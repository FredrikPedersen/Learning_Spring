package com.fredrik.pedersen.restclientexamples.service;

import com.fredrik.pedersen.api.domain.User;
import com.fredrik.pedersen.api.domain.UserData;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 13/02/2020 at 22:06
 */

@Service
public class ApiServiceImpl implements ApiService {

    private RestTemplate restTemplate;

    public ApiServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<User> getUsers(Integer limit) {

        UserData userData = restTemplate.getForObject("http://apifaketory.com/api/user?limit=" + limit, UserData.class);
        return userData.getData();
    }
}
