package st.nvt.managerrestaurant.model.service;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double price;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Food_Ingredient",
        joinColumns = @JoinColumn(name = "idFood", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "idIngredient", referencedColumnName = "id"))
    private List<Ingredient> ingredientList;

    @OneToMany(mappedBy = "food",cascade = CascadeType.ALL)
    private List<Images> images;

}
