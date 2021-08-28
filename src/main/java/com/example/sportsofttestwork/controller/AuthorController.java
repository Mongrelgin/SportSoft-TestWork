package com.example.sportsofttestwork.controller;

import com.example.sportsofttestwork.entity.Author;
import com.example.sportsofttestwork.service.AuthorService;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @RequestMapping("/author")
    public String genre(HttpServletRequest request) {
        request.setAttribute("mode", "MODE_AUTHOR");
        return "mainscreen";
    }

    @RequestMapping("/add-author")
    public String addAuthor(@RequestParam String name, @RequestParam MultipartFile image, HttpServletRequest request) throws IOException {
        Author author = new Author();
        author.setName(Jsoup.parse(name).text());
        author.setPicture(image.getBytes());
        authorService.saveAuthor(author);

        request.setAttribute("authors", authorService.getAllAuthors());
        request.setAttribute("mode", "MODE_AUTHORS");
        return "mainscreen";
    }

    /*
    @RequestMapping("/add-author")
    public String addAuthor(@ModelAttribute Author author, BindingResult bindingResult, HttpServletRequest request) {
        System.out.println(author.getId());
        System.out.println(author.getName());
        System.out.println(author.getPicture());

        authorService.saveAuthor(author);
        request.setAttribute("authors", authorService.getAllAuthors());
        request.setAttribute("mode", "MODE_AUTHORS");
        return "mainscreen";
    }

     */
    /*

    @RequestMapping("/delete-genre")
    public String deleteGenre(@RequestParam Long id, HttpServletRequest request) {
        genreService.deleteGenre(id);
        request.setAttribute("genres", genreService.getAllGenres());
        request.setAttribute("mode","MODE_GENRE");
        return "mainscreen";
    }

    @RequestMapping("/edit-genre")
    public String editUser(@RequestParam Long id, HttpServletRequest request) {
        request.setAttribute("genre", genreService.getGenreById(id));
        request.setAttribute("mode","MODE_UPDATE_GENRE");
        return "mainscreen";
    }
     */
}
