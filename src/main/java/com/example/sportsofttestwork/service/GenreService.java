package com.example.sportsofttestwork.service;

import com.example.sportsofttestwork.entity.Author;
import com.example.sportsofttestwork.entity.Genre;
import com.example.sportsofttestwork.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class GenreService {
    private static final Logger LOGGER = Logger.getLogger(GenreService.class.getName());
    private final GenreRepository repository;

    @Autowired
    public GenreService(GenreRepository repository) {
        this.repository = repository;
    }
    public List<Genre> getAllGenres() {
        return (List<Genre>) repository.findAll();
    }

    public Genre getGenreById(Long id) {
        return repository.findById(id).get();
    }

    public void deleteGenre(Genre genre) {
        if (genre.getBooks().size() == 0) {
            LOGGER.log(Level.SEVERE, "Can't delete genres to which books are linked!");
            return;
        }
        repository.delete(genre);
    }

    public void saveGenre(Genre genre) {
        if (genre == null) {
            LOGGER.log(Level.SEVERE, "Genre is null!");
            return;
        }
        repository.save(genre);
    }
}
