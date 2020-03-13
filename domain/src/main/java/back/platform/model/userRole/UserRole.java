package back.platform.model.userRole;

import back.platform.model.role.Role;
import back.platform.model.user.AppUser;

import javax.persistence.*;
import java.io.Serializable;

//@Entity
//@Table(name = "user_roles")
public class UserRole implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userRole_ID;
    @ManyToOne
    private Role role;
    @ManyToOne
    private AppUser user;

    public UserRole() {
    }

    public UserRole(Role role, AppUser user) {
        this.role = role;
        this.user = user;
    }

    public Long getUserRole_ID() {
        return userRole_ID;
    }

    public void setUserRole_ID(Long userRole_ID) {
        this.userRole_ID = userRole_ID;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "userRole_ID=" + userRole_ID +
                ", role=" + role +
                ", user=" + user +
                '}';
    }
}
