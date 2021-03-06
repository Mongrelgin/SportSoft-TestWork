package com.example.sportsofttestwork.service;

import com.example.sportsofttestwork.entity.Author;
import com.example.sportsofttestwork.entity.User;
import com.example.sportsofttestwork.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class UserService {
    private static final Logger LOGGER = Logger.getLogger(UserService.class.getName());
    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }
    public List<User> getAllUsers() {
        return (List<User>) repository.findAll();
    }

    public User getUserById(Long id) {
        return repository.findById(id).get();
    }

    public void deleteUser(Long id) {
        repository.deleteById(id);
    }

    public void saveUser(User user) {
        if (user == null) {
            LOGGER.log(Level.SEVERE, "User is null!");
            return;
        }
        repository.save(user);
    }

    public User findByLoginAndPass(String login, String pass) {
        return repository.findByLoginAndPass(login, pass);
    }
}
