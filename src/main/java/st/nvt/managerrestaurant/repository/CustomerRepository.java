package st.nvt.managerrestaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import st.nvt.managerrestaurant.model.account.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    boolean existsByEmail(String email);
}
