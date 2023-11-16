package st.nvt.managerrestaurant.model.service;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import st.nvt.managerrestaurant.model.service.Food;
import st.nvt.managerrestaurant.model.service.Restaurant;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Images {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameImage;
    private String typeImage;
    @Lob
    @Column(length = 60000)
    private byte[] dataImage;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "food")
    private Food food;

    @ManyToOne
    @JoinColumn(name = "restaurant")
    private Restaurant restaurant;

}
