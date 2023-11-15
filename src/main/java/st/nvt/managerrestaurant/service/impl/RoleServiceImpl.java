package st.nvt.managerrestaurant.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import st.nvt.managerrestaurant.model.account.Role;
import st.nvt.managerrestaurant.repository.IRoleRepository;
import st.nvt.managerrestaurant.service.IRoleService;

@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private IRoleRepository iRoleRepository;

    @Override
    public Role findByRoleName(String name) {
        return iRoleRepository.findByRoleName(name);
    }
}
