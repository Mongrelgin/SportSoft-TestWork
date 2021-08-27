package com.example.sportsofttestwork.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class User extends AbstractEntity {
    @NotNull
    @NotEmpty
    private String login;

    @NotNull
    @NotEmpty
    private String pass;


    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
