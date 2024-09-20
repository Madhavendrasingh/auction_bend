package org.negi.auction_backend.service;

import org.negi.auction_backend.model.User;
import org.negi.auction_backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<User> getAll(){
        return userRepository.findAll();
    }

    public User getById(Integer id){
        return userRepository.findById(id).orElse(null);
    }

    public User save(String name, String email){
        User user = new User();
        user.setEmail(email);
        user.setName(name);
        userRepository.save(user);
        return user;
    }

    public void remove(Integer id){
        userRepository.deleteById(id);
    }
}
