package com.talgreen.demosite.service;

import com.talgreen.demosite.dao.BookStoreDao;
import com.talgreen.demosite.model.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BookStoreServiceTest {

    private static final Book B1 = new Book(1, "1", "a", 1997, 20, 12);
    private static final Book B2 = new Book(2, "2", "b", 1998, 21, 11);
    private static final Book B3 = new Book(3, "3", "c", 1999, 20, 10);

@Mock
    BookStoreDao dao;

    @Test
    public void Given_store_with_books_When_sorting_by_id_Then_sorted_list_is_returned() {
        BookStoreService store = new BookStoreService(dao);

        List<Book> unsortedBooks = new ArrayList<>();
        unsortedBooks.add(B3);
        unsortedBooks.add(B2);
        unsortedBooks.add(B1);

        when(dao.getBooks()).thenReturn(unsortedBooks);

        List<Book> booksSortedById = store.getBooksSortedById();

        assertThat(booksSortedById).containsExactly(B1, B2, B3);
    }

}