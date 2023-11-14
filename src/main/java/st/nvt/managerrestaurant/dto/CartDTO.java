package st.nvt.managerrestaurant.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import st.nvt.managerrestaurant.model.account.Customer;
import st.nvt.managerrestaurant.model.service.Food;

import java.util.HashMap;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CartDTO {
    private Customer customer;

    private double totalPrice = 0.0;

    private int totalItems = 0;

    private  Food food;
}
