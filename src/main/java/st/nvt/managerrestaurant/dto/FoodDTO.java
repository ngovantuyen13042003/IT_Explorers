package st.nvt.managerrestaurant.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import st.nvt.managerrestaurant.model.service.Images;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FoodDTO {
    private String name;
    private String description;
    private Double price;
    private String  ingredientList;
    private String images;
}
