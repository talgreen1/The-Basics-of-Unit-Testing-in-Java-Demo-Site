package com.talgreen.demosite.dao;

import com.talgreen.demosite.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BookStoreDao {
    private List<Book> books;

    public BookStoreDao() {
        books = new ArrayList<>();
        // Add some starter books
        books.add(new Book(1, "The Hobbit", "J. R. R. Tolkien", 1937, 20.99, 3));
        books.add(new Book(2, "Harry Potter", "J. K. Rowling", 1997, 56.99, 10));
        books.add(new Book(3, "The Wizard of Oz", "L. Frank Baum", 1900, 87, 10));
    }

    public int getBookCount() {
        return books.size();
    }

    public boolean contains(Book book) {
        return books.contains(book);
    }

    public void add(Book book) {
        books.add(book);
    }

    public Book getBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    public Book removeBookById(int id) {
        Book res = null;

        for (Book book : books) {
            if (book.getId() == id) {
                books.remove(book);
                res = book;
                break;
            }
        }
        return res;
    }

    public List<Book> getBooks() {
        return books;
    }
}
