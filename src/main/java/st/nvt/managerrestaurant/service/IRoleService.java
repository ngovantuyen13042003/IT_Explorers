package st.nvt.managerrestaurant.service;

import st.nvt.managerrestaurant.model.account.Erole;
import st.nvt.managerrestaurant.model.account.Role;

import java.util.Optional;

public interface IRoleService {
    Role findByRoleName(String name);
}
