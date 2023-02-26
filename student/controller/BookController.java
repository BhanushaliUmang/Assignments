package com.example.student.controller;

import java.util.List;
import java.util.UUID;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.student.model.Book;
import com.example.student.repo.StudentRepo;
import com.example.student.service.BookService;

@RestController
public class BookController {
    @Autowired
    private BookService service;
    @Autowired
    private StudentRepo stu1;
    @PostMapping("/postbook")
    public String postbook(@RequestBody String book){
        JSONObject json = new JSONObject(book);
        Book book1 = setBook(json);
            service.addbook(book1);
            return "Book details saved";
    }

    private Book setBook(JSONObject json) {
      Book b = new Book();
        b.setAuthor(json.getString("author"));
        String Id = UUID.randomUUID().toString();
        b.setID(Id);
        b.setDescription(json.getString("description"));
        b.setPrice(json.getString("price"));
        b.setTitle(json.getString("title"));

        String stuid = json.getString("studentid");

        b.setStudent(stu1.findById(stuid).get());
         return b;
        
    }

    @DeleteMapping("/delete/Book/{id}")
    public String deleteBookById(@PathVariable String id){
           service.deleteBookById(id);
           return "Deleted Sucessfully";
    }

    @GetMapping("/getBook")
    public List<Book> getAllBook(){
        return service.getAllbook();
    }

    @GetMapping("/getBook/{id}")
    public Book getBookById(@PathVariable String id){
        return service.getBookById(id);
    }

    @PutMapping("/updateBook/{id}")
    public String updateBook(@PathVariable String id , @RequestBody Book book){
          service.updatebook(id,book);


        return "updated sucessfully";
    }
}
