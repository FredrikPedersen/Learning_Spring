package com.fredrikpedersen.resttemplatedemo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fredrikpedersen.resttemplatedemo.models.PostDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 20/06/2021 at 18:13
 */


class TypicodeControllerTest {

    private final String BASE_URL = "https://jsonplaceholder.typicode.com/posts/";

    @Mock
    private RestTemplate restTemplate;

    private TypicodeController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        controller = new TypicodeController(restTemplate);

    }

    @Nested
    class get {

        @Test
        void success() throws JsonProcessingException {

            //given
            final PostDTO expectedResult = PostDTO.builder().id(1).userId(1).body("someBoyd").title("someTitle").build();
            given(restTemplate.getForEntity(BASE_URL + "1", String.class)).willReturn(new ResponseEntity<>(new ObjectMapper().writeValueAsString(expectedResult), HttpStatus.OK));

            //when
            final String actualResult = controller.getPost();

            //then
            assertEquals(expectedResult.toString(), actualResult);
        }

        @Test
        void fail() {

            //given
            given(restTemplate.getForEntity(BASE_URL + "1", String.class)).willReturn(new ResponseEntity<>(null, HttpStatus.BAD_REQUEST));

            //when/then
            assertThrows(RuntimeException.class, () -> controller.getPost());
        }
    }
}