package st.nvt.managerrestaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import st.nvt.managerrestaurant.model.account.Account;

import java.util.Optional;

@Repository
public interface IAccountRepository extends JpaRepository<Account, Long> {
    Account findByUserName(String name); // Tìm username có trong DB không
    Boolean existsByUserName(String name); // check username đã có trong DB chưa

}
