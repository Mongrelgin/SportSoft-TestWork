package com.example.sportsofttestwork.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class Book extends AbstractEntity{

    @NotNull
    @NotEmpty
    private String title;

    @NotNull
    @NotEmpty
    private Long counter;

    @Lob
    private byte[] picture;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", genre=" + genre +
                ", author=" + author +
                '}';
    }

}
