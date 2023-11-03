package st.nvt.managerrestaurant.service;

import st.nvt.managerrestaurant.dto.CartDTO;

import java.util.HashMap;

public interface CartService {
    HashMap<Long, CartDTO> addCart(Long id, HashMap<Long, CartDTO> cart) ;

    HashMap<Long, CartDTO> editCart(Long id, int quantity,HashMap<Long, CartDTO> cart) ;

    HashMap<Long, CartDTO> removeCart(Long id,HashMap<Long, CartDTO> cart) ;
    int totalQuantity(HashMap<Long, CartDTO> cart);
    double totalPrice(HashMap<Long, CartDTO> cart);


}
