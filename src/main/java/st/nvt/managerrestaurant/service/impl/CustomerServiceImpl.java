package st.nvt.managerrestaurant.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import st.nvt.managerrestaurant.model.account.Customer;
import st.nvt.managerrestaurant.repository.CustomerRepository;
import st.nvt.managerrestaurant.service.CustomerService;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;


    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }
}
