package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Crudmodel;
import service.Crudservice;

@RestController
@RequestMapping("/api")
public class Crudcontroller {
    @Autowired
    private Crudservice crud_Service;

    @GetMapping("/findUser")
    public List<Crudmodel> getListofUser(){
        return crud_Service.findAll();
    }

    @GetMapping("/find/{id}")
	 public Crudmodel findTodoById(@PathVariable int id) {
	       return crud_Service.findById(id);
	}

    @PostMapping("add-Restaurant")
	 public void addRestaurant(Crudmodel UserDetails) {
		 
        crud_Service.addUser(UserDetails);
	}

    @PutMapping("update-Restaurant")
    public void updateTodo(@PathVariable int userid, @RequestBody Crudmodel user) {
        crud_Service.updateById(userid,user);
    }

    @DeleteMapping("/delete/{RestaurantId}")
	    public void deleteTodo(@PathVariable int RestaurantId) {
            crud_Service.deleteById(RestaurantId);
	}
}
