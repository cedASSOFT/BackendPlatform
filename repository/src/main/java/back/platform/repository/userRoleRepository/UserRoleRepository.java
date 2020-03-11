package back.platform.repository.userRoleRepository;

import back.platform.model.userRole.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
}
