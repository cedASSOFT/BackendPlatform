package back.platform.service.roleService;

import back.platform.model.role.Role;
import org.springframework.stereotype.Service;

@Service
public interface IRoleService {
    Role findByRoleName(String rolename);
}
