package back.platform.model.userRole;

import back.platform.model.role.Role;
import back.platform.model.user.User;

import javax.persistence.*;

@Entity
@Table(name = "user_roles")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userRole_ID;
    @ManyToOne
    private Role role;
    @ManyToOne
    private User user;

    public UserRole() {
    }

    public UserRole(Role role, User user) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
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
