package com.fredrikpedersen.resttemplatedemo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fredrikpedersen.resttemplatedemo.models.PostDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 20/06/2021 at 16:58
 */

@RestController
@RequiredArgsConstructor
public class TypicodeController {

    private final String RESROURCE_URL = "https://jsonplaceholder.typicode.com/posts/";
    private final RestTemplate restTemplate;

    @RequestMapping("/get")
    public String getPost() throws JsonProcessingException {
        final ResponseEntity<String> response = restTemplate.getForEntity(RESROURCE_URL + "1", String.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            final PostDTO postDTO = new ObjectMapper().readValue(response.getBody(), PostDTO.class);
            return postDTO.toString();
        }

        throw new RuntimeException(String.valueOf(response.getStatusCode()));
    }

    @RequestMapping("/post")
    public String postPost() throws JsonProcessingException {
        final HttpEntity<PostDTO> request = new HttpEntity<>(PostDTO.builder().id(2).userId(1).body("someBody").title("someTitle").build());
        final ResponseEntity<String> response = restTemplate.postForEntity(RESROURCE_URL, request, String.class);

        if (response.getStatusCode() == HttpStatus.CREATED) {
            final PostDTO postDTO = new ObjectMapper().readValue(response.getBody(), PostDTO.class);
            return postDTO.toString();
        }

        throw new RuntimeException(String.valueOf(response.getStatusCode()));
    }
}
