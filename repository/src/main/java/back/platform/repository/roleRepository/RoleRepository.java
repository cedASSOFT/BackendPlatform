package back.platform.repository.roleRepository;

import back.platform.model.role.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleName(String rolename);

}
