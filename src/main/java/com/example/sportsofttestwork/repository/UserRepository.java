package com.example.sportsofttestwork.repository;

import com.example.sportsofttestwork.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    public User findByLoginAndPass(String login, String pass);
}
