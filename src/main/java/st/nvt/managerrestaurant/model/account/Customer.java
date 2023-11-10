package st.nvt.managerrestaurant.model.account;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import st.nvt.managerrestaurant.model.payment.Order;
import st.nvt.managerrestaurant.model.service.Cart;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String address;
    private int totalScores;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_order")
    private Order order;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<Cart> carts = new ArrayList<>();



}
