package st.nvt.managerrestaurant.service;

import jakarta.transaction.Transactional;
import st.nvt.managerrestaurant.model.service.Cart;
import st.nvt.managerrestaurant.model.service.Food;

import java.util.List;
import java.util.Optional;

@Transactional
public interface CartService {

    void addCart(Long foodId, Long cusId)  throws Exception;

    List<Cart> getAll(Long id) ;

    void remove(Long id);
}
