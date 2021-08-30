package com.example.sportsofttestwork.service;

import com.example.sportsofttestwork.entity.Author;
import com.example.sportsofttestwork.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class AuthorService {
    private static final Logger LOGGER = Logger.getLogger(AuthorService.class.getName());
    private final AuthorRepository repository;

    @Autowired
    public AuthorService(AuthorRepository repository) {
        this.repository = repository;
    }

    public List<Author> getAllAuthors() {
        return (List<Author>) repository.findAll();
    }

    public Author getAuthorById(Long id) {
        return repository.findById(id).get();
    }

    public void deleteAuthor(Long id) {
        if (repository.findById(id).get().getBooks().size() > 0) {
            LOGGER.log(Level.SEVERE, "Can't delete authors to which books are linked!");
            return;
        }
        repository.deleteById(id);
    }

    public void saveAuthor(Author author) {
        if (author == null) {
            LOGGER.log(Level.SEVERE, "Author is null!");
            return;
        }
        repository.save(author);
    }
}
