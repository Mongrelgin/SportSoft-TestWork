package com.example.sportsofttestwork.repository;

import com.example.sportsofttestwork.entity.Genre;
import org.springframework.data.repository.CrudRepository;

public interface GenreRepository extends CrudRepository<Genre, Long> {
}
