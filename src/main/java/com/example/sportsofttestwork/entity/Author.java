package com.example.sportsofttestwork.entity;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.LinkedList;
import java.util.List;

@Entity
@Data
public class Author extends AbstractEntity {
    @NotNull
    @NotEmpty
    private String name;

    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Book> books = new LinkedList<>();

    public Author() {
    }

    public Author(String name) {
        this.name = name;
    }
}
