package com.talgreen.demosite.service;

import com.talgreen.demosite.dao.BookStoreDao;
import com.talgreen.demosite.model.Book;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BookStoreServiceFilterTest {

    private static final Book B1_A = new Book(1, "1", "a", 1997, 100, 12);
    private static final Book B2_A = new Book(2, "2", "a", 1998, 150, 11);
    private static final Book B3_B = new Book(3, "3", "b", 1999, 40, 10);

    @Mock
    private BookStoreDao dao;
    private BookStoreService store;
    private List<Book> booksList;


    @Before
    public void prepareStore() {
        store = new BookStoreService(dao);
        booksList = new ArrayList<>();
    }
/*-------------------------------------------------
        Sort By Author Tests
 -------------------------------------------------*/

    @Test
    public void Given_store_with_books_When_filtering_by_existing_author_Then_only_books_of_the_author_are_returned() {
        booksList.add(B1_A);
        booksList.add(B2_A);
        booksList.add(B3_B);

        when(dao.getBooks()).thenReturn(booksList);

        List<Book> booksFilteredByAuthor = store.getBooksByAuthor(B1_A.getAuthor());

        assertThat(booksFilteredByAuthor).containsExactlyInAnyOrder(B1_A, B2_A);
    }

    @Test
    public void Given_store_with_books_When_filtering_by_non_existing_author_Then_only_books_of_the_author_are_returned() {
        booksList.add(B1_A);
        booksList.add(B2_A);
        booksList.add(B3_B);

        when(dao.getBooks()).thenReturn(booksList);

        List<Book> booksFilteredByAuthor = store.getBooksByAuthor("NON_EXISTING_AUTHOR");

        assertThat(booksFilteredByAuthor).isEmpty();
    }

    @Test
    public void Given_empty_store_When_filtering_by_author_Then_empty_list_returned() {
        when(dao.getBooks()).thenReturn(booksList);

        List<Book> booksFilteredByAuthor = store.getBooksByAuthor("A");

        assertThat(booksFilteredByAuthor).isEmpty();
    }

}