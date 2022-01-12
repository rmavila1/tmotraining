package com.galvanize.tmo.paspringstarter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class BookController {

    @Autowired
    BookService bookService;

    // to post
    //@RequestMapping(method = RequestMethod.POST, value = "/api/books")
    @PostMapping(value = "/books")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        book.id = bookService.booksManager.books.size() + 1;
        bookService.addToList(book);
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    // get all books sorted alphabetically by title

    //@RequestMapping(method = RequestMethod.GET, value = "/api/books")
    @GetMapping("/books")
    public ResponseEntity<BooksManager> getListOfBooks() {
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }

    // delete all books
    //@RequestMapping(method = RequestMethod.DELETE, value = "/api/books")
    @DeleteMapping(value = "/books")
    public ResponseEntity<Book> deleteAll() {
        bookService.deleteAllBooks();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
