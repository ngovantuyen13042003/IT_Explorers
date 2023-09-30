package st.nvt.managerrestaurant.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import st.nvt.managerrestaurant.model.service.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
    @Override
    Page<Food> findAll(Pageable pageable);

    @Query("SELECT f from Food f where f.id = ?1")
    Food getById(Long id);
}
