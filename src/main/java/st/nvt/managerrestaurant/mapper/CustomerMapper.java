package st.nvt.managerrestaurant.mapper;

import st.nvt.managerrestaurant.dto.CustomerDTO;
import st.nvt.managerrestaurant.model.account.Customer;

public class CustomerMapper {

    public static Customer mapperToCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setName(customerDTO.getName());
        customer.setEmail(customerDTO.getEmail());
        customer.setAddress(customerDTO.getAddress());
        return customer;
    }

    public static CustomerDTO mapperToCustomerDTO(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setName(customer.getName());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setAddress(customer.getAddress());
        return customerDTO;
    }
}
