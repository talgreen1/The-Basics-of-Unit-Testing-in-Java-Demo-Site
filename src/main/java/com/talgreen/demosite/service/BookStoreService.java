package com.talgreen.demosite.service;

import com.talgreen.demosite.dao.BookStoreDao;
import com.talgreen.demosite.model.Book;
import com.talgreen.demosite.model.BookComparators;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class BookStoreService {

    private final BookStoreDao dao;

    public BookStoreService(BookStoreDao dao) {
        this.dao = dao;
    }

    public int getBookCount() {
        return dao.getBookCount();
    }

    /**
     * Add a new book to the book store.
     *
     * @param book The book to add
     * @return The book if it was added, null if the book already exists
     */
    public Book addBook(Book book) {
        if (dao.contains(book)) {
            return null;
        } else {
            dao.add(book);
            return book;
        }
    }

    /**
     * Return a book by it's ID
     *
     * @param id The ID of the book to return
     * @return The book if it was found, otherwise null
     */
    public Book getBookById(int id) {
        return dao.getBookById(id);
    }

    /**
     * This method returns a list of books written by a specific author
     *
     * @param author The author of the books
     * @return List of books written by the author parameter. If there are no such books, empty list will be returned.
     */
    public List<Book> getBooksByAuthor(String author) {
        return dao.getBooksByAuthor(author);
    }

    /**
     * This method updates an existing book. It gets a book, search an existing book with the same id and updates it.
     *
     * @param updatedBook The updated book
     * @return If an existing book was updated, the old book is returned. If the book didn't exist, null will be return.
     */
    public Book updateBook(Book updatedBook) {
        Book book = removeBookById(updatedBook.getId());
        if (book == null) {
            return null;
        }

        addBook(updatedBook);
        return book;
    }

    /**
     * Removes a book by it's id
     *
     * @param id The id of the book to remove
     * @return The removed book. If the book didn't exist, null will be return.
     */
    public Book removeBookById(int id) {
        return dao.removeBookById(id);
    }

    public List<Book> getBooksSortedById() {
        List<Book> books = dao.getBooks();
        Collections.sort(books, BookComparators::idComparator);
        return books;
    }

    public List<Book> getBooksSortedByName() {
        List<Book> books = dao.getBooks();
        Collections.sort(books, BookComparators::nameComparator);
        return books;
    }

    public List<Book> getBooksSortedByPrice() {
        List<Book> books = dao.getBooks();
        Collections.sort(books, BookComparators::priceComparator);
        return books;
    }

    public List<Book> getBooksSortedByYear() {
        List<Book> books = dao.getBooks();
        Collections.sort(books, BookComparators::yearComparator);
        return books;
    }

    public List<Book> getBooks() {
        return dao.getBooks();
    }

    /**
     * Sells a book - remove it's stock count by one.
     *
     * @param id
     * @return
     */
    public Book sellBook(int id) {
        Book book = getBookById(id);
        int stockCount = book.getStockCount();
        if (stockCount == 0) {
            throw new RuntimeException("Book is not in stock");
        }

        book.setPrice(stockCount - 1);
        return book;
    }

}
