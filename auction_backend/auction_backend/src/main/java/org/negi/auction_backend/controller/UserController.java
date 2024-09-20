package org.negi.auction_backend.controller;

import org.negi.auction_backend.model.User;
import org.negi.auction_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String get(){
        return "Server is running!";
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Integer id){
        return userService.getById(id);
    }

    @GetMapping("/user")
    public Iterable<User> getAllUsers(){
        return userService.getAll();
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable Integer id){
        try {
            User user = userService.getById(id);
            if ( user != null ) {
                userService.remove(id);
                return "User removed successfully.";
            }
            else
                return "No such user exists. Check the id!";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @PutMapping("/user")
    public User addUser(@RequestBody User user){
        return userService.save(user.getName(),user.getEmail());
    }
}
