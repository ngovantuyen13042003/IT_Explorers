package st.nvt.managerrestaurant.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {
    @NotEmpty(message = "User name should not be empty!")
    private String userName;
    @NotEmpty(message = "Password should not be empty!")
    @Size(min = 6, message = "Password must be at least 6 characters long!")
    private String password;
    @NotEmpty(message = "Email should not be empty!")
    @Email(message = "Invalid email!")
    private  String email;
}
