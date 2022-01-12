package com.galvanize.tmo.paspringstarter;

import java.util.ArrayList;
import java.util.List;

public class BooksManager {
    List<Book> books = new ArrayList<>();

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }


}
