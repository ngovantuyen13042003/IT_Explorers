package st.nvt.managerrestaurant.model.account;

import jakarta.persistence.*;
import lombok.*;
import st.nvt.managerrestaurant.model.service.Restaurant;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@ToString
@Entity
public class Account{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(updatable = false)
    private String userName;
    @Column(updatable = false)
    private String password;

    private Long customerId;

    private Long restaurantId;

    private Long staffId;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "Account_Role",
        joinColumns = @JoinColumn(name = "id_Account", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "id_Role", referencedColumnName = "id"))
    private List<Role> roleList = new ArrayList<>();

}
