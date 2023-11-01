package st.nvt.managerrestaurant.model.account;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Account{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String password;
    private String email;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "Account_Role",
        joinColumns = @JoinColumn(name = "id_Account", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "id_Role", referencedColumnName = "id"))
    private List<Role> roleList = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL)
    private Staff staff;


    @ManyToOne(cascade = CascadeType.ALL)
    private Customer customer;


}
