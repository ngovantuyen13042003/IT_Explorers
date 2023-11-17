package st.nvt.managerrestaurant.model.service;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
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

    private String phoneNumber;

    @ManyToOne(cascade = CascadeType.ALL)
    private TypeRestaurant typeRestaurant;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurant")
    private List<Table> tables;

    @OneToMany(mappedBy = "restaurant",cascade = CascadeType.ALL)
    private List<Images> images;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurant")
    private List<Food> foods = new ArrayList<>();
}
