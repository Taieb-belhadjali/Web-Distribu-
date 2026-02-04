package tn.managementuser.controller;

import org.springframework.web.bind.annotation.*;
import tn.managementuser.entity.User;
import tn.managementuser.service.UserService;

import java.util.List;

@RestController
@RequestMapping("user")
@CrossOrigin(origins = "*")
public class UserRestController {
    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("add")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping("getusers")
    public List<User> getUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("get/{id}")
    public User getUser(@PathVariable("id") Long user_id) {
        return userService.findById(user_id);
    }

    @PutMapping("update")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("delete/{id}")
    public void deleteById(@PathVariable("id") Long user_id) {
        userService.deleteById(user_id);
    }
}
