package st.nvt.managerrestaurant.service;

import jakarta.transaction.Transactional;
import st.nvt.managerrestaurant.model.account.Customer;

import java.util.Optional;

@Transactional
public interface CustomerService {
    Optional<Customer> findById(Long id);

}
