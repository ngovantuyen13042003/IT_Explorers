package st.nvt.managerrestaurant.service;

import st.nvt.managerrestaurant.model.account.Role;

public interface IRoleService {
    Role findByRoleName(String name);
}
