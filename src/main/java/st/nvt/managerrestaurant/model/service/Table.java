package st.nvt.managerrestaurant.model.service;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import st.nvt.managerrestaurant.model.payment.Reservation;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@jakarta.persistence.Table(name = "tblTable")
public class Table {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int slot;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_satus")
    private StatusTable statusTable;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reservation")
    private Reservation reservation;

    @ManyToOne(cascade = CascadeType.ALL)
    private Restaurant restaurant;
}
