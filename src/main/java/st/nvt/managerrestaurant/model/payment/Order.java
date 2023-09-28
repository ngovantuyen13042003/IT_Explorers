package st.nvt.managerrestaurant.model.payment;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import st.nvt.managerrestaurant.model.service.Food;
import st.nvt.managerrestaurant.model.service.Table;

import java.sql.Timestamp;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@jakarta.persistence.Table(name = "tblOrder")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Timestamp orderDateTime;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Order_Food",
        joinColumns = @JoinColumn(name = "id_Order", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "id_food", referencedColumnName = "id"))
    private List<Food> foodList;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_table")
    private Table table;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "PayMethod_Order",
        joinColumns = @JoinColumn(name = "id_Order", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "id_payMethod", referencedColumnName = "id"))
    private List<PaymentMethod> paymentMethods;


}
