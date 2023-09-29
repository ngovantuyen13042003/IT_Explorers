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
    @NotEmpty(message = "Food name should be not Empty!")
    private String name;
    @NotEmpty(message = "Food description should be not Empty!")
    private String description;
    @NotEmpty(message = "Food price should be not Empty!")
    private Double price;
    @NotEmpty(message = "Food ingredient should be not Empty!")
    private String  ingredientList;
    @NotEmpty(message = "There should be at least 1 image of the food!")
    private List<Images> images;
}
