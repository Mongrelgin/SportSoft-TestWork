package com.example.sportsofttestwork.controller;

import com.example.sportsofttestwork.entity.Genre;
import com.example.sportsofttestwork.service.AuthorService;
import com.example.sportsofttestwork.service.BookService;
import com.example.sportsofttestwork.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LibraryController {
    @Autowired
    private BookService bookService;
    @Autowired
    private GenreService genreService;
    @Autowired
    private AuthorService authorService;

    @RequestMapping("/genre")
    public String genre(HttpServletRequest request) {
        request.setAttribute("mode", "MODE_GENRE");
        return "mainscreen";
    }

    @RequestMapping("/add-genre")
    public String addGenre(@ModelAttribute Genre genre, BindingResult bindingResult, HttpServletRequest request) {
        System.out.println(genre.getId());
        genreService.saveGenre(genre);
        request.setAttribute("genres", genreService.getAllGenres());
        request.setAttribute("mode", "MODE_GENRE");
        return "mainscreen";
    }

    @RequestMapping("/delete-genre")
    public String deleteGenre(@RequestParam Long id, HttpServletRequest request) {
        genreService.deleteGenre(id);
        request.setAttribute("genres", genreService.getAllGenres());
        request.setAttribute("mode","MODE_GENRE");
        return "mainscreen";
    }

    @RequestMapping("/edit-genre")
    public String editUser(@RequestParam Long id, HttpServletRequest request) {
        System.out.println(id + " " + genreService.getGenreById(id).getId());
        request.setAttribute("genre", genreService.getGenreById(id));
        request.setAttribute("mode","MODE_UPDATE_GENRE");
        return "mainscreen";
    }
}
