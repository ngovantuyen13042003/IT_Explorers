package st.nvt.managerrestaurant.mapper;

import st.nvt.managerrestaurant.dto.AccountDTO;
import st.nvt.managerrestaurant.model.account.Account;
import st.nvt.managerrestaurant.util.EncodePassword;

public class AccountMapper {
    public static Account toAccountEntity(AccountDTO userDTO){
        Account user = new Account();

        user.setUserName(userDTO.getUserName());
        user.setPassword(EncodePassword.passwordEncoder().encode(userDTO.getPassword()));
        user.setEmail(userDTO.getEmail());

        return user;
    }

    public static AccountDTO toUserDTO(Account user){
        AccountDTO userDTO = new AccountDTO();

        userDTO.setUserName(user.getUserName());
        userDTO.setPassword(user.getPassword());
        userDTO.setEmail(user.getEmail());

        return userDTO;
    }
}
