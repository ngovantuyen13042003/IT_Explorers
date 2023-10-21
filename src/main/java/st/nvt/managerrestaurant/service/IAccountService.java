package st.nvt.managerrestaurant.service;

import st.nvt.managerrestaurant.dto.AccountDTO;
import st.nvt.managerrestaurant.model.account.Account;


public interface IAccountService {
    Account findByUserName(String name); // Tìm username có trong DB không
    Boolean existsByUserName(String name); // check username đã có trong DB chưa
    Boolean existsByEmail(String email);
    Account saveOrUpdate(AccountDTO account);
}
