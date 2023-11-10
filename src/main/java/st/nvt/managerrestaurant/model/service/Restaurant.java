package st.nvt.managerrestaurant.model.service;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    private String email;

    private String country;

    private String phoneNumber;




    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Restaurant_Food",
        joinColumns = @JoinColumn(name = "id_restaurant", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "id_Food", referencedColumnName = "id"))
    private List<Food> menu;

    @ManyToOne(cascade = CascadeType.ALL)
    private TypeRestaurant typeRestaurant;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_table")
    private Table tables;

    @OneToMany(mappedBy = "restaurant",cascade = CascadeType.ALL)
    private List<Images> images;

}
