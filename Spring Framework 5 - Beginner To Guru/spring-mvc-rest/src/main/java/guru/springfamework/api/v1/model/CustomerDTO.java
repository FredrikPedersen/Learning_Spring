package guru.springfamework.api.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

    @ApiModelProperty(value = "This is the Customer's first name", required = true)
    private String firstname;

    @ApiModelProperty(value = "This is the Customer's last name", required = true)
    private String lastname;

    @JsonProperty("customer_url")
    private String customerUrl;
}
