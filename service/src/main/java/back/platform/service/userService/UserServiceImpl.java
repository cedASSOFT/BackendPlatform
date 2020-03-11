package back.platform.service.userService;

import back.platform.exceptions.notFoundExceptions.User_IDNotFoundException;
import back.platform.exceptions.registrationException.EmailAlreadyExistException;
import back.platform.exceptions.registrationException.PasswordConfirmationException;
import back.platform.exceptions.registrationException.UsernameAlreadyExistException;
import back.platform.message.responseMessage.SuccessRegistration;
import back.platform.model.role.Role;
import back.platform.model.user.User;
import back.platform.model.user.regisration.RegistrationForm;
import back.platform.repository.roleRepository.RoleRepository;
import back.platform.repository.userRepository.UserRepository;
import back.platform.service.roleService.IRoleService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements IUserService, IRoleService {

    private final static Logger LOGGER = LogManager.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public ResponseEntity<?> saveUser(RegistrationForm form) throws UsernameAlreadyExistException, EmailAlreadyExistException {

        //Check if given username exists
        if (existByEmail(form.getUsername()))
            throw new UsernameAlreadyExistException(form.getUsername() + " -> Already exists you must choose another one!");

        //Check if given email exists
        if (existByEmail(form.getEmail()))
            throw new EmailAlreadyExistException(form.getEmail() + " -> Already exists you must choose another one!");

        if (!form.getPassword().equals(form.getConfirmPassword()))
            throw new PasswordConfirmationException("You must confirm your password");

        String password = passwordEncoder().encode(form.getPassword());

        User user = new User(form.getFirstname(), form.getLastname(), form.getUsername(), form.getEmail(), password, true);

        addRoleToUser(form.getUsername(), "ROLE_USER");

        userRepository.save(user);
        return new ResponseEntity<>(new SuccessRegistration("User " + "->" + user.getFirstname() + " registered successfully!"), HttpStatus.OK);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findByUser_ID(Long user_ID) {
        return userRepository.findById(user_ID);
    }

    @Override
    public Boolean deletedUser(Long user_ID) {

        if (existByUser_ID(user_ID) == null) {
            throw new User_IDNotFoundException("This user_ID: " + user_ID + " not found");
        }
        userRepository.deleteById(user_ID);
        return true;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Boolean existByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public Boolean existByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public Boolean existByUser_ID(Long user_ID) {
        return userRepository.existsByUser_ID(user_ID);
    }

    @Override
    public Role findByRoleName(String rolename) {
        return roleRepository.findByRoleName(rolename);
    }

    @Override
    public void addRoleToUser(String username, String rolename) {
        User user = findByUsername(username);
        Role role = findByRoleName(rolename);
        user.getRoles().add(role);
    }

}
