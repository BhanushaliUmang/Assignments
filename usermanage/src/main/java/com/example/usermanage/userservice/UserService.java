package com.example.usermanage.userservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.usermanage.usermodel.UserModel;
import com.example.usermanage.userrepository.UserRepo;

@Service
public class UserService {
    
    @Autowired
    UserRepo repository;

    public UserModel saveUser(UserModel user) {
        return repository.save(user);
    }

    public List<UserModel> getAll() {
        return repository.findAll();
    }

    public UserModel getbyId(int id) {
        return repository.findById(id).get();
    }

    public void updateUser(int id, UserModel newmodel) {

        UserModel users = getbyId(id);
        users.setUserName(newmodel.getUserName());
        users.setMail(newmodel.getMail());
        users.setPhoneNumber(newmodel.getPhoneNumber());
        users.setDateOfBirth(newmodel.getDateOfBirth());

        repository.save(users);

    }

    public void deleteuser(int id) {
        UserModel model = getbyId(id);
        repository.delete(model);
    }
}
