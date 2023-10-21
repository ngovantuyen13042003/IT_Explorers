package st.nvt.managerrestaurant.service.impl;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import st.nvt.managerrestaurant.dto.AccountDTO;
import st.nvt.managerrestaurant.mapper.AccountMapper;
import st.nvt.managerrestaurant.model.account.Account;
import st.nvt.managerrestaurant.model.account.Role;
import st.nvt.managerrestaurant.repository.IAccountRepository;
import st.nvt.managerrestaurant.repository.IRoleRepository;
import st.nvt.managerrestaurant.service.IAccountService;

import java.util.Arrays;

@Service
@Transactional
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountRepository accountRepository;
    @Autowired
    IRoleRepository roleRepository;


    @Override
    public Account findByUserName(String name) {
        return accountRepository.findByUserName(name);
    }

    @Override
    public Boolean existsByUserName(String name) {
        return accountRepository.existsByUserName(name);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return accountRepository.existsByEmail(email);
    }

    @Override
    public Account saveOrUpdate(AccountDTO accountDTO) {
        Account account = AccountMapper.toAccountEntity(accountDTO);

        Role role = roleRepository.findByRoleName("USER");

        if(role == null){
            role = checkRoleExists();
        }

        // Gắn kết role với account
        account.setRoleList(Arrays.asList(role));

        return accountRepository.save(account);
    }

    private Role checkRoleExists(){
        Role role = new Role();
        role.setRoleName("USER");
        return  roleRepository.save(role);
    }


}
