package com.example.sportsofttestwork.controller;

import com.example.sportsofttestwork.entity.Book;
import com.example.sportsofttestwork.service.AuthorService;
import com.example.sportsofttestwork.service.BookService;
import com.example.sportsofttestwork.service.GenreService;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private GenreService genreService;

    @RequestMapping("/book")
    public String book(HttpServletRequest request) {
        request.setAttribute("books", bookService.getAllBooks());
        request.setAttribute("mode", "MODE_BOOK");
        request.setAttribute("authorsList", authorService.getAllAuthors());
        request.setAttribute("genresList", genreService.getAllGenres());
        return "mainscreen";
    }

    @RequestMapping("/add-book")
    public String addBook(@RequestParam String title, @RequestParam MultipartFile picture, @RequestParam Long author, @RequestParam Long genre, HttpServletRequest request) throws IOException {
        Book book = new Book();

        //System.out.println(author.getClass().getName());

        book.setTitle(Jsoup.parse(title).text());
        book.setPicture(picture.getBytes());
        book.setAuthor(authorService.getAuthorById(author));
        book.setGenre(genreService.getGenreById(genre));
        bookService.saveBook(book);

        request.setAttribute("books", bookService.getAllBooks());
        request.setAttribute("mode", "MODE_BOOK");
        return "mainscreen";
    }

    @RequestMapping("delete-book")
    public String deleteBook(@RequestParam Long id, HttpServletRequest request) {
        bookService.deleteBook(id);
        request.setAttribute("books", bookService.getAllBooks());
        request.setAttribute("mode","MODE_BOOK");
        return "mainscreen";
    }
}
