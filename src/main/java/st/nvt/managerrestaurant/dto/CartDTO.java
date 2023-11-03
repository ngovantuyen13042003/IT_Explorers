package st.nvt.managerrestaurant.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import st.nvt.managerrestaurant.model.service.Food;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CartDTO {
    private int quantity;
    private double total;
    private Food food;
}
