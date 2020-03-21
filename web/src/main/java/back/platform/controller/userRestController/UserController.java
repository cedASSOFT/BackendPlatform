package back.platform.controller.userRestController;

import back.platform.model.user.AppUser;
import back.platform.service.userService.IUserService;
import back.platform.service.userService.UserServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    private UserServiceImpl userService;
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }


    @GetMapping("/admin/users")
    @ApiOperation(value = "View a list of available users", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public List<AppUser> getUsers() {
        return userService.findAll();
    }

    @GetMapping("/admin/user/{user_ID}")
    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation(value = "Get an user by Id if you have a ADMIN role")
    public Optional<AppUser> getUser(
            @ApiParam(value = "User id from which user object will be retrieve", required = true) @PathVariable Long user_ID) {
        return userService.findByUser_ID(user_ID);
    }

    @DeleteMapping("/admin/delete/user/{user_ID}")
    @PreAuthorize("hasRole('ADMIN')")
    public Boolean deleteUser(@PathVariable Long user_ID) {
        return userService.deletedUser(user_ID);
    }

    @PutMapping("/admin/update/user")
    @PreAuthorize("hasRole('ADMIN')")
    public AppUser updateUser(@RequestBody AppUser user) {
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
