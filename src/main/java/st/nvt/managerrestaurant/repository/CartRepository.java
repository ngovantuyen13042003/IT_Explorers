package st.nvt.managerrestaurant.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import st.nvt.managerrestaurant.model.service.Cart;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    boolean existsCartByFoodIdAndCustomerId(Long fooId, Long cusId);
    Cart findCartByFoodIdAndCustomerId(Long fooId, Long cusId);

    void  removeCartByFoodId(Long id);

    List<Cart> findCartByCustomerId(Long id);

}
