package st.nvt.managerrestaurant.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter@Getter @AllArgsConstructor @NoArgsConstructor
public class RestaurantOwnerDTO {
    //    @NotEmpty(message = "Customer's name should be not null or empty")
    private String name;
    @NotEmpty(message = "Email should be not null or empty")
    @Email(message = "Email invalid")
    private String email;
    private String address;
    @NotEmpty(message = "Username should be not null or empty")
    private String username;
    @NotEmpty(message = "Password should be not null or empty")
    private String password;
}
