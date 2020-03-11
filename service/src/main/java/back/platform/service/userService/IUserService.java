package back.platform.service.userService;

import back.platform.exceptions.registrationException.EmailAlreadyExistException;
import back.platform.exceptions.registrationException.UsernameAlreadyExistException;
import back.platform.model.user.User;
import back.platform.model.user.regisration.RegistrationForm;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IUserService {
    ResponseEntity<?> saveUser(RegistrationForm form) throws UsernameAlreadyExistException, EmailAlreadyExistException;

    List<User> findAll();

    Optional<User> findByUser_ID(Long user_ID);

    Boolean deletedUser(Long user_ID);

    User updateUser(User user);

    User findByUsername(String username);

    Boolean existByEmail(String email);

    Boolean existByUsername(String username);

    Boolean existByUser_ID(Long user_ID);

    void addRoleToUser(String username, String rolename);


}
