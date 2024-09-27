package org.negi.auction_backend.controller;

import jakarta.validation.Valid;
import org.negi.auction_backend.dto.LoginDto;
import org.negi.auction_backend.model.User;
import org.negi.auction_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String get(){
        return "Server is running!";
    }

    @GetMapping("/api/user")
    public User getUserById(@RequestParam Integer id){
        System.out.println(id);
        return userService.getById(id);
    }

    @GetMapping("/users")
    public Iterable<User> getAllUsers(){
        return userService.getAll();
    }

    @DeleteMapping("/api/user/{id}")
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

    @PutMapping("/api/user")
    public User addUser( @RequestBody User user){
        System.out.println(user.getPassword()+"in the controller"+user.getEmail());
        return userService.save(user.getName(),user.getEmail(),user.getPassword());
    }

    @GetMapping("/api/user/email")
    public User getUserByEmail(@RequestParam String email){
        return this.userService.getByEmail(email);
    }

    @GetMapping("/api/user/ids")
    public List<User> getByIds(@RequestBody List<Integer> ids){
        return this.userService.getUserList(ids);
    }

    @GetMapping("/api/user/login")
    public String login(@RequestBody LoginDto loginDto){
        return this.userService.login(loginDto.getEmail(),loginDto.getPassword());
    }
}
