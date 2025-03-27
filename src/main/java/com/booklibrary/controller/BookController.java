package com.booklibrary.controller;

import org.springframework.stereotype.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.booklibrary.model.Book;
import com.booklibrary.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {
    
    @Autowired
    private BookRepository bookRepository;
    
    @PostMapping("/add")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book savedBook = bookRepository.save(book);
        return ResponseEntity.ok(savedBook);
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<Book>> viewAllBooks() {
        return ResponseEntity.ok(bookRepository.findAll());
    }
    
    @GetMapping("/search")
    public ResponseEntity<?> searchBook(@RequestParam(required = false) String id, @RequestParam(required = false) String title) {
        if (id != null) {
            Optional<Book> book = bookRepository.findById(id);
            return book.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        }
        return ResponseEntity.badRequest().body("Provide an ID to search.");
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable String id, @RequestBody Book updatedBook) {
        return bookRepository.findById(id).map(book -> {
            book.setTitle(updatedBook.getTitle());
            book.setAuthor(updatedBook.getAuthor());
            book.setStatus(updatedBook.getStatus());
            return ResponseEntity.ok(bookRepository.save(book));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable String id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return ResponseEntity.ok("Book deleted successfully.");
        }
        return ResponseEntity.notFound().build();
    }
}
