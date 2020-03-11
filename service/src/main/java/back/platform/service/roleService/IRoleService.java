package back.platform.service.roleService;

import back.platform.model.role.Role;

public interface IRoleService {
    Role findByRoleName(String rolename);
}
