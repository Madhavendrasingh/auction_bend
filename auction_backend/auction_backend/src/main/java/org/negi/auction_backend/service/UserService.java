package org.negi.auction_backend.service;

import org.negi.auction_backend.model.User;
import org.negi.auction_backend.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService{
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public Iterable<User> getAll(){
        return userRepository.findAll();
    }

    public User getById(Integer id){
        return userRepository.findById(id).orElse(null);
    }

    public User save(String name, String email, String password){
        User user = new User();
        user.setEmail(email);
        user.setName(name);
        System.out.println(password+"in the service");
        user.setPassword(passwordEncoder.encode(password));
        this.userRepository.save(user);
        return user;
    }

    public void remove(Integer id){
        userRepository.deleteById(id);
    }

    public User getByEmail(String email){
        return this.userRepository.findByEmail(email);
    }

    public List<User> getUserList(List<Integer> ids){
        return this.userRepository.findAllById(ids);
    }

    public String login(String email, String password) {
        User user = this.userRepository.findByEmail(email);
        if (this.passwordEncoder.matches(password, user.getPassword()))
            return "TOKEN";
        else
            return "Failure";
    }

    public String logout(){
        return "logout";
    }
}
