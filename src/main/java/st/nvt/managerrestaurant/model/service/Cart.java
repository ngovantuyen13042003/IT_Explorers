package st.nvt.managerrestaurant.model.service;

import jakarta.persistence.*;
import lombok.*;
import st.nvt.managerrestaurant.model.account.Customer;

import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Long customerId;
    private Long foodId;
    private String foodName;
    private String ingredient;
    private Double foodPrice;
    private String foodImages;
    private int totalItems ;
    private double totalPrice;
}
