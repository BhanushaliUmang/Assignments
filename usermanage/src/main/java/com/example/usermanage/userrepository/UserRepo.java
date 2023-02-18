package com.example.usermanage.userrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.usermanage.usermodel.UserModel;

@Repository
public interface UserRepo extends JpaRepository<UserModel,Integer>{
    
    
}
