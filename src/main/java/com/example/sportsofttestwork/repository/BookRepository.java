package com.example.sportsofttestwork.repository;

import com.example.sportsofttestwork.entity.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}