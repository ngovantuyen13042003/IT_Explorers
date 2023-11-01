package st.nvt.managerrestaurant.model.service;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import st.nvt.managerrestaurant.model.account.Customer;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int amount;
    private Double total;
    @ManyToMany(cascade =  CascadeType.ALL)
    @JoinTable(name = "Cart_Food",
            joinColumns = @JoinColumn(name = "cart_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "food_id", referencedColumnName = "id"))
    private List<Food> foods = new ArrayList<>();
    @ManyToOne(cascade = CascadeType.ALL)
    private Customer customer;


}
