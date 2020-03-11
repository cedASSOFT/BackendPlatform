package back.platform.controller;

import back.platform.model.user.User;
import back.platform.service.userService.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/admin/users")
    public List<User> getUsers() {
        return userService.findAll();
    }

    @GetMapping("/admin/user/{user_ID}")
    @PreAuthorize("hasRole('ADMIN')")
    public Optional<User> getUser(@PathVariable Long user_ID) {
        return userService.findByUser_ID(user_ID);
    }

    @DeleteMapping("/admin/delete/user/{user_ID}")
    @PreAuthorize("hasRole('ADMIN')")
    public Boolean deleteUser(@PathVariable Long user_ID) {
        return userService.deletedUser(user_ID);
    }

    @PutMapping("/admin/update/user")
    @PreAuthorize("hasRole('ADMIN')")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    //initial
    @GetMapping("/user")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public String userAccess() {
        return ">>> User Contents!";
    }

    @GetMapping("/pm")
    @PreAuthorize("hasRole('PM') or hasRole('ADMIN')")
    public String projectManagementAccess() {
        return ">>> Project Management Board";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return ">>> Admin Contents";
    }
}
