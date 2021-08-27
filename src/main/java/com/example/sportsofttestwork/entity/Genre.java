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
public class Genre extends AbstractEntity {
    @NotNull
    @NotEmpty
    private String title;

    @OneToMany(mappedBy = "genre", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Book> books = new LinkedList<>();

    public Genre() {
    }

    public Genre(String title) {
        this.title = title;
    }
}
