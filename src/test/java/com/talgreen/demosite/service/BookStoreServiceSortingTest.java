package com.talgreen.demosite.service;

import com.talgreen.demosite.dao.BookStoreDao;
import com.talgreen.demosite.model.Book;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SuppressWarnings("Duplicates")
@RunWith(MockitoJUnitRunner.class)
public class BookStoreServiceSortingTest {

    private static final Book B1 = new Book(1, "1", "a", 1997, 100, 12);
    private static final Book B2 = new Book(2, "2", "b", 1998, 150, 11);
    private static final Book B3 = new Book(3, "3", "c", 1999, 40, 10);

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
        Sort By ID Tests
 -------------------------------------------------*/

    @Test
    public void Given_store_with_books_When_sorting_by_id_Then_sorted_list_is_returned() {
        booksList.add(B3);
        booksList.add(B2);
        booksList.add(B1);

        when(dao.getBooks()).thenReturn(booksList);

        List<Book> booksSortedById = store.getBooksSortedById();

        assertThat(booksSortedById).containsExactly(B1, B2, B3);
    }

    @Test
    public void Given_store_with_1_book_When_sorting_by_id_Then_1_book_returned() {
        booksList.add(B3);

        when(dao.getBooks()).thenReturn(booksList);

        List<Book> booksSortedById = store.getBooksSortedById();

        assertThat(booksSortedById).containsExactly(B3);
    }

    @Test
    public void Given_empty_store_When_sorting_by_id_Then_empty_list_returned() {
        when(dao.getBooks()).thenReturn(booksList);

        List<Book> booksSortedById = store.getBooksSortedById();

        assertThat(booksSortedById).isEmpty();
    }

    @Test
    public void Given_store_with_sorted_books_by_id_When_sorting_by_id_Then_sorted_list_is_returned() {
        booksList.add(B1);
        booksList.add(B2);
        booksList.add(B3);

        when(dao.getBooks()).thenReturn(booksList);

        List<Book> booksSortedById = store.getBooksSortedById();

        assertThat(booksSortedById).containsExactly(B1, B2, B3);
    }

    /*-------------------------------------------------
        Sort By Price Tests
 -------------------------------------------------*/

    @Test
    public void Given_store_with_books_When_sorting_by_price_Then_sorted_list_is_returned() {
        booksList.add(B1);
        booksList.add(B2);
        booksList.add(B3);

        when(dao.getBooks()).thenReturn(booksList);

        List<Book> booksSortedByPrice = store.getBooksSortedByPrice();

        assertThat(booksSortedByPrice).containsExactly(B3, B1, B2);
    }

    @Test
    public void Given_store_with_1_book_When_sorting_by_price_Then_1_book_returned() {
        booksList.add(B1);

        when(dao.getBooks()).thenReturn(booksList);

        List<Book> booksSortedByPrice = store.getBooksSortedByPrice();

        assertThat(booksSortedByPrice).containsExactly(B1);
    }

    @Test
    public void Given_empty_store_When_sorting_by_price_Then_empty_list_returned() {
        when(dao.getBooks()).thenReturn(booksList);

        List<Book> booksSortedByPrice = store.getBooksSortedByPrice();

        assertThat(booksSortedByPrice).isEmpty();
    }

    @Test
    public void Given_store_with_sorted_books_by_price_When_sorting_by_id_Then_sorted_list_is_returned() {
        booksList.add(B3);
        booksList.add(B1);
        booksList.add(B2);

        when(dao.getBooks()).thenReturn(booksList);

        List<Book> booksSortedByPrice = store.getBooksSortedByPrice();

        assertThat(booksSortedByPrice).containsExactly(B3, B1, B2);
    }

}