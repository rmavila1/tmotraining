package com.galvanize.tmo.paspringstarter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController
public class LibraryController {

    int id = 1;
    List<Book> bookList = new ArrayList<Book>();
    @GetMapping("/health")
    public void health() {
    }

    @GetMapping("/books")
    public List<Book> getBooks() {
        return bookList;
    }

    @PostMapping(value = "/books", produces = "application/json")
    public ResponseEntity<Book> addBooks(@RequestBody Book book) {

        book.setId(id);
        bookList.add(book);
        id++;
        return new ResponseEntity<Book>(book, HttpStatus.CREATED);
    }


    @DeleteMapping(value = "/books")
    public ResponseEntity deleteBooks(){
        bookList.clear();
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
