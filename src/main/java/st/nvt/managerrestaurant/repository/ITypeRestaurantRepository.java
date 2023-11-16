package st.nvt.managerrestaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import st.nvt.managerrestaurant.model.service.TypeRestaurant;
@Repository
public interface ITypeRestaurantRepository extends JpaRepository<TypeRestaurant, Long> {
}
