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
import java.io.File;
import java.io.IOException;

@Controller
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @RequestMapping("/author")
    public String genre(HttpServletRequest request) {
        return setAuthorScreen(request);
    }

    @RequestMapping("/add-author")
    public String addAuthor(@RequestParam String name, @RequestParam MultipartFile image, HttpServletRequest request) throws IOException {
        Author author = new Author();
        author.setName(Jsoup.parse(name).text());
        author.setPicture(image.getBytes());
        authorService.saveAuthor(author);

        String path = "C:\\Users\\mongr\\Desktop\\Sportsoft\\SportSoft-TestWork\\pics\\authors\\" + image.getName() + ".jpg";
        image.transferTo(new File(path));

        return setAuthorScreen(request);
    }

    @RequestMapping("/delete-author")
    public String deleteAuthor(@RequestParam Long id, HttpServletRequest request) {
        authorService.deleteAuthor(id);
        return setAuthorScreen(request);
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
        return setAuthorScreen(request);
    }

    private String setAuthorScreen(HttpServletRequest request) {
        String mode = "MODE_AUTHOR";

        request.setAttribute("authors", authorService.getAllAuthors());
        request.setAttribute("mode",mode);
        return "mainscreen";
    }
}
