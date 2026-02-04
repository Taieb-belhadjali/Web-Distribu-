package tn.managementuser.service;

import org.springframework.stereotype.Service;
import tn.managementuser.entity.User;
import tn.managementuser.repository.UserRepository;

import java.util.List;

@Service
//@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User addUser(User user) {
        //user.setRole(Role.ROLE_EMPLOYEE);
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(Long user_id) {
        userRepository.deleteById(user_id);
    }

    @Override
    public User findById(Long user_id) {
        return userRepository.findById(user_id).orElse(null);
    }

    @Override
    public List<User> findAllUsers() {
        return (List<User>) userRepository.findAll();
    }
}
