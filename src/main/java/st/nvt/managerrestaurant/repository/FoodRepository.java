package st.nvt.managerrestaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import st.nvt.managerrestaurant.model.service.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {

}
