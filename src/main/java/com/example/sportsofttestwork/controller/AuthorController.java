package com.example.sportsofttestwork.controller;

import com.example.sportsofttestwork.entity.Author;
import com.example.sportsofttestwork.service.AuthorService;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
        request.setAttribute("authors", authorService.getAllAuthors());
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
        request.setAttribute("mode", "MODE_AUTHOR");
        return "mainscreen";
    }

    @RequestMapping("/delete-author")
    public String deleteAuthor(@RequestParam Long id, HttpServletRequest request) {
        authorService.deleteAuthor(id);
        request.setAttribute("authors", authorService.getAllAuthors());
        request.setAttribute("mode","MODE_AUTHOR");
        return "mainscreen";
    }

    @RequestMapping("/edit-author")
    public String editAuthor(@RequestParam Long id, HttpServletRequest request) {
        request.setAttribute("author", authorService.getAuthorById(id));
        request.setAttribute("mode","MODE_UPDATE_AUTHOR");
        return "mainscreen";
    }

    @RequestMapping("/update-author")
    public String updateAuthor(@RequestParam Long id, @RequestParam String name, HttpServletRequest request) {
        authorService.getAuthorById(id).setName(name);
        request.setAttribute("authors", authorService.getAllAuthors());
        request.setAttribute("mode","MODE_AUTHOR");
        return "mainscreen";
    }
}
