package st.nvt.managerrestaurant.service.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import st.nvt.managerrestaurant.model.account.Customer;
import st.nvt.managerrestaurant.model.service.Cart;
import st.nvt.managerrestaurant.model.service.Food;
import st.nvt.managerrestaurant.model.service.Images;
import st.nvt.managerrestaurant.repository.CartRepository;
import st.nvt.managerrestaurant.service.*;

import java.util.*;

@Service
@Transactional
public class CartServiceImpl implements CartService {
    @Autowired
    CartRepository cartRepository;
    @Autowired
    ImagesService imagesService;
    @Autowired
    FoodService foodService;
    @Autowired
    CustomerService customerService;
    @Autowired
    IAccountService accountService;

@PersistenceContext
private EntityManager entityManager;

    @Override
    public void addCart(Long foodId, Long cusId) throws Exception {
        Customer customer = customerService.findById(cusId).orElseThrow(() -> new Exception("Customer not found"));
        Food food = foodService.findById(foodId);

        if (cartRepository.existsCartByFoodIdAndCustomerId(foodId, cusId)) {
            // Nếu giỏ hàng đã tồn tại, cập nhật số lượng
            Cart existingCart = cartRepository.findCartByFoodIdAndCustomerId(foodId, cusId);
            int quantity = existingCart.getTotalItems() + 1;
            updateCartTotalItems(existingCart, quantity);
        } else {
            // Nếu giỏ hàng không tồn tại, tạo mới giỏ hàng
            Cart newCart = new Cart();
            newCart.setCustomerId(customer.getId());
            newCart.setFoodName(food.getName());
            newCart.setIngredient(food.getIngredientList());
            newCart.setFoodPrice(food.getPrice());
            newCart.setFoodId(foodId);
            newCart.setTotalItems(1);
            newCart.setTotalPrice(food.getPrice());

            Images image = imagesService.findTop1ByFood(foodId);
            newCart.setFoodImages(image.getNameImage());

            cartRepository.save(newCart);
        }
    }

    public void updateCartTotalItems(Cart cart, int quantity) {
        cart.setTotalItems(quantity);
        cart.setTotalPrice(cart.getFoodPrice() * quantity);
        cartRepository.save(cart);
    }

    @Override
    public List<Cart> getAll(Long cusId) {
        List<Cart> carts = cartRepository.findCartByCustomerId(cusId);
        if(carts == null) {
            carts = new ArrayList<>();
        }
        return carts;
    }

    public void remove(Long id) {
        cartRepository.removeCartByFoodId(id);
    }

}
