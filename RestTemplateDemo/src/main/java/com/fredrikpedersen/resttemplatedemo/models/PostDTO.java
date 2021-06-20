package com.fredrikpedersen.resttemplatedemo.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 20/06/2021 at 17:16
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO implements Serializable {

    @JsonProperty("userId")
    private int userId;

    @JsonProperty("id")
    private int id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("body")
    private String body;
}
