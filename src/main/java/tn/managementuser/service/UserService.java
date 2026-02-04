package tn.managementuser.service;
import tn.managementuser.entity.User;

import java.util.List;

public interface UserService {
    User addUser(User user);
    User updateUser(User user);
    void deleteById(Long user_id);
    User findById(Long user_id);
    List<User> findAllUsers();
}
