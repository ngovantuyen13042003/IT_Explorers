    package st.nvt.managerrestaurant.model.service;

    import jakarta.persistence.*;
    import jakarta.persistence.Table;
    import lombok.*;

    import java.util.ArrayList;
    import java.util.List;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    @Entity
    public class Food {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;
        private String description;
        private Double price;
        private String  ingredientList;

        @OneToMany(mappedBy = "food",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
        private List<Images> images;

        @ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "restaurantId")
        private Restaurant restaurant;
    }
