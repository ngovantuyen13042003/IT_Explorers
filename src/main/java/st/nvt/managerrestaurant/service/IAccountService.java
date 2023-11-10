package st.nvt.managerrestaurant.service;

import jakarta.transaction.Transactional;
import st.nvt.managerrestaurant.dto.AccountDTO;
import st.nvt.managerrestaurant.dto.CustomerDTO;
import st.nvt.managerrestaurant.model.account.Account;

@Transactional
public interface IAccountService {
    Account findByUserName(String name); // Tìm username có trong DB không
    Boolean existsByUserName(String name); // check username đã có trong DB chưa

    Account saveOrUpdate(CustomerDTO customerDTO);
}
