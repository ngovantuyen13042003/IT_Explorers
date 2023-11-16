package st.nvt.managerrestaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import st.nvt.managerrestaurant.model.service.Food;
import st.nvt.managerrestaurant.model.service.Images;
import st.nvt.managerrestaurant.model.service.Restaurant;

import java.util.List;
import java.util.Optional;

@Repository
public interface ImagesRepository extends JpaRepository<Images, Long> {
    List<Images> findByFood(Food food);

    List<Images> findByRestaurant(Restaurant restaurant);

    @Query("SELECT i FROM Images i WHERE i.food.id = ?1 ORDER BY i.id ASC LIMIT 1")
    Images findTop1ByFood(Long id);

    boolean existsById(Long id);
}
