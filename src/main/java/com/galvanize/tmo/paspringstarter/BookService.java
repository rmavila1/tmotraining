package com.galvanize.tmo.paspringstarter;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BookService {

    public BooksManager booksManager = new BooksManager();

    // post one
    public void addToList(Book book) {

        booksManager.books.add(book);
    }

    // get all books
    public BooksManager getAllBooks() {

        Comparator<Book> bookComparator = new Comparator<Book>() {
            public int compare(Book b1, Book b2) {
                return b1.title.compareToIgnoreCase(b2.title);
            }
        };
        Collections.sort(booksManager.books, bookComparator);
        return booksManager;
    }

    // to delete all
    public void deleteAllBooks() {
        booksManager.books.clear();
    }

}
