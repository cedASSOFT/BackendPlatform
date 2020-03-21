package back.platform.controller.userRestController;

import back.platform.exceptions.registrationException.EmailAlreadyExistException;
import back.platform.exceptions.registrationException.UsernameAlreadyExistException;
import back.platform.model.user.AppUser;
import back.platform.model.user.regisration.RegistrationForm;
import back.platform.service.userService.IUserService;
import back.platform.service.userService.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@Api(value = "Register an management API", description = "Implementing registering a new user")
public class AuthenticationAndRegisterController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/index")
    public String index() {
        return "Spring Boot POC Welcomes You!";
    }

    @RequestMapping ("/swagger")
    public String home() {
        return "redirect:/swagger-ui.html";
    }

    @ApiOperation(value = "Add a new user with default role as USER")
    @PostMapping("/signup")
    public AppUser registration(@RequestBody RegistrationForm form) throws EmailAlreadyExistException,
            UsernameAlreadyExistException {
        return userService.saveUser(form);
    }


}
