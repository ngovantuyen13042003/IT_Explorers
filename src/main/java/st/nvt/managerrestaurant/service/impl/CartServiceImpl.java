package st.nvt.managerrestaurant.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import st.nvt.managerrestaurant.dto.CartDTO;
import st.nvt.managerrestaurant.model.service.Cart;
import st.nvt.managerrestaurant.model.service.Food;
import st.nvt.managerrestaurant.repository.CartRepository;
import st.nvt.managerrestaurant.service.CartService;
import st.nvt.managerrestaurant.service.FoodService;

import java.util.HashMap;
import java.util.Map;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    FoodService foodService;
    @Autowired
    CartRepository cartRepository;

    @Override
    public HashMap<Long, CartDTO> addCart(Long id, HashMap<Long, CartDTO> cart) {
        CartDTO itemCart = new CartDTO();
        Food food = foodService.findById(id);
        if(food != null && cart.containsKey(id)) {
            itemCart = cart.get(id);
            int quantity = itemCart.getQuantity();
            itemCart.setQuantity(quantity + 1);
            itemCart.setTotal((quantity + 1) * itemCart.getFood().getPrice());
        }else {
            itemCart.setFood(food);
            itemCart.setQuantity(1);
            double totalPrice = food.getPrice() * itemCart.getQuantity();
            itemCart.setTotal(totalPrice);
        }

        cart.put(food.getId(), itemCart);
        return cart;
    }

    @Override
    public HashMap<Long, CartDTO> editCart(Long id, int quantity, HashMap<Long, CartDTO> cart) {
        if(cart == null) {
            return cart;
        }
        CartDTO itemCart = new CartDTO();
        if(cart.containsKey(id)) {
            itemCart = cart.get(id);
            itemCart.setQuantity(quantity);
            itemCart.setTotal(itemCart.getFood().getPrice() * quantity);
        }

        cart.put(id, itemCart);
        return null;
    }

    @Override
    public HashMap<Long, CartDTO> removeCart(Long id, HashMap<Long, CartDTO> cart) {
        if(cart == null) {
            return cart;
        }
        if(cart.containsKey(id)) {
            cart.remove(id);
        }
        return cart;
    }

    @Override
    public int totalQuantity(HashMap<Long, CartDTO> cart) {
        int totalQuantity = 0;
        for(Map.Entry<Long, CartDTO> itemCart : cart.entrySet()) {
            totalQuantity += itemCart.getValue().getQuantity();
        }

        return totalQuantity;
    }

    @Override
    public double totalPrice(HashMap<Long, CartDTO> cart) {
        double totalPrice= 0;
        for(Map.Entry<Long, CartDTO> itemCart : cart.entrySet()) {
            totalPrice += (itemCart.getValue().getTotal());
        }
        return totalPrice;
    }

}
