package com.example.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.student.model.Book;
import com.example.student.repo.BookRepo;
@Service
public class BookService {
    @Autowired
     BookRepo repo;

    public void addbook(Book book) {
              repo.save(book);
    }

    public void deleteBookById(String id) {
        repo.deleteById(id);
    }

    public List<Book> getAllbook() {
        return repo.findAll();
    }

    public Book getBookById(String id) {
        return repo.findById(id).get();
    }

    public void updatebook(String id, Book book) {
        Book b = repo.findById(id).get();
        b.setAuthor(book.getAuthor());
        b.setDescription(book.getDescription());
        b.setPrice(book.getPrice());
        b.setTitle(book.getTitle());
        repo.save(b);

    }

    
}
