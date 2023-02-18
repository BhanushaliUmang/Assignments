package com.example.usermanage.usercontroller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.usermanage.usermodel.UserModel;
import com.example.usermanage.userservice.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {
    
    @Autowired
    UserService service;

    @PostMapping("/adduser")

   public ResponseEntity<?> registerUser(@Valid @RequestBody UserModel user) {
      user.setDate(LocalDate.now());
      user.setTime(LocalTime.now());
      UserModel registeredUser = service.saveUser(user);
      return ResponseEntity.ok(registeredUser);
   }

   @GetMapping("/GetAll")
   public List<UserModel> getAll() {
      return service.getAll();
   }

   @GetMapping("/user/{id}")

   public UserModel getbyId(@PathVariable int id) {
      return service.getbyId(id);
   }

   @PutMapping("/users/{id}")
   public void updateUser(@PathVariable int id, @RequestBody UserModel model) {
      service.updateUser(id, model);
   }

   @DeleteMapping("/delete/{id}")
   public void deleteuser(@PathVariable int id) {
      service.deleteuser(id);
   }
}
