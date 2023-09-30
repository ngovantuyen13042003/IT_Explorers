package st.nvt.managerrestaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import st.nvt.managerrestaurant.model.service.Food;
import st.nvt.managerrestaurant.model.service.Images;

import java.util.List;

@Repository
public interface ImagesRepository extends JpaRepository<Images, Long> {
    List<Images> findByFood(Food food);

    @Query("SELECT i FROM Images i WHERE i.food.id = ?1 ORDER BY i.id ASC LIMIT 1")
    Images findTop1ByFood(Long id);

}
