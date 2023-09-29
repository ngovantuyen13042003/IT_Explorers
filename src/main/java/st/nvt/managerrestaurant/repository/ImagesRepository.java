package st.nvt.managerrestaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import st.nvt.managerrestaurant.model.service.Food;
import st.nvt.managerrestaurant.model.service.Images;

import java.util.List;

@Repository
public interface ImagesRepository extends JpaRepository<Images, Long> {
    List<Images> findByFood(Food food);
}
