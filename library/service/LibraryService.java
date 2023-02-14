package com.example.library.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.library.model.Library;

@Service
public class LibraryService {
    
    private static final  List<Library> library =new ArrayList<>();
        private static int id=0;
        
        static {
            Library s1=new Library(++id,"Sardar Library","Bhuj","9988774561","Open for half day");
            library.add(s1);
            Library s2=new Library(++id,"College Library","Mandvi","8896547856","Reading and classes");
            library.add(s2);
            Library s3=new Library(++id,"State Libarary","Gandhinagar","9966547896","Open for full day");
            library.add(s3);
            Library s4=new Library(++id,"Om Library","Ahmedabad","9658745589","Open for full day");
            library.add(s4);
        }
       
        public Library getLibname(String name) {
            return library.stream().filter(t -> t.getName().equals(name)).findFirst().get();
        }
    
        public void addLib(Library lib){
            library.add(lib);
        }
    
        public List<Library> getAll(){
            return library;
    
        }
}
