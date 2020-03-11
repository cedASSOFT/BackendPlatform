package back.platform.controller;

import back.platform.exceptions.registrationException.EmailAlreadyExistException;
import back.platform.exceptions.registrationException.UsernameAlreadyExistException;
import back.platform.model.user.regisration.RegistrationForm;
import back.platform.service.userService.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/auth")
public class AuthenticationAndRegisterController {

    @Autowired
    private IUserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> registration(@RequestBody RegistrationForm form) throws EmailAlreadyExistException,
            UsernameAlreadyExistException {
        return userService.saveUser(form);
    }


}
