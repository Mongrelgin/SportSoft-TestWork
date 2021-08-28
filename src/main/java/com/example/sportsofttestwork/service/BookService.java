package com.example.sportsofttestwork.service;

import com.example.sportsofttestwork.entity.Author;
import com.example.sportsofttestwork.entity.Book;
import com.example.sportsofttestwork.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class BookService  {
    private static final Logger LOGGER = Logger.getLogger(BookService.class.getName());
    private final BookRepository repository;

    @Autowired
    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public List<Book> getAllBooks() {
        return (List<Book>) repository.findAll();
    }

    public Book getBookById(Long id) {
        return repository.findById(id).get();
    }

    public void deleteBook(Long id) {
        repository.deleteById(id);
    }

    public void saveBook(Book book) {
        if (book == null) {
            LOGGER.log(Level.SEVERE, "Book is null!");
            return;
        }
        repository.save(book);
    }
}
