package com.example.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.model.Library;
import com.example.library.service.LibraryService;

@RestController
@RequestMapping("/api/v2")
public class LibraryController {
    
    @Autowired

    private LibraryService service;

    @GetMapping("/lib/Libname/{name}")
    public Library getLibname(@PathVariable String name){
       return service.getLibname(name);
    }

    @GetMapping("/findall")
    public List<Library> getAll(){
       return service.getAll();
    }
    @PostMapping("/addlibrary")
    public void addLib(@RequestBody Library lib){
       service.addLib(lib);

    } 
}
