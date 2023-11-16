package st.nvt.managerrestaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import st.nvt.managerrestaurant.model.service.Restaurant;

@Repository
public interface IRestaurantRepository extends JpaRepository<Restaurant, Long> {
    @Query("SELECT res from Restaurant res where res.id= ?1")
    Restaurant getById(Long id);

    boolean existsById(Long id);
}
