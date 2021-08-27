package com.example.sportsofttestwork.repository;

import com.example.sportsofttestwork.entity.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
