package com.talgreen.demosite.controller;

import com.talgreen.demosite.model.Book;
import com.talgreen.demosite.service.BookStoreService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController()
@RequestMapping("v1/books")
public class BookStoreController {

    private BookStoreService bookStoreService;

    public BookStoreController(BookStoreService bookStoreService) {
        this.bookStoreService = bookStoreService;
    }

    @GetMapping
    public List<Book> getAll(HttpServletResponse response) {
        return bookStoreService.getBooks();
    }

    @GetMapping("/sort_id")
    public List<Book> getBooksSortedById(HttpServletResponse response){
        return bookStoreService.getBooksSortedById();
    }

    @GetMapping("/sort_name")
    public List<Book> getBooksSortedByName(HttpServletResponse response){
        return bookStoreService.getBooksSortedByName();
    }

    @GetMapping("/filter_author/{author}")
    public List<Book> getBooks(@PathVariable String author, HttpServletResponse response){
        return bookStoreService.getBooksByAuthor(author);
    }
}
