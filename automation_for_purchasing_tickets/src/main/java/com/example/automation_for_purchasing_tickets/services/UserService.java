package com.example.automation_for_purchasing_tickets.services;

import com.example.automation_for_purchasing_tickets.dtos.UserRecord;
import com.example.automation_for_purchasing_tickets.models.UserModel;
import com.example.automation_for_purchasing_tickets.repositorys.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserModel saveUser(UserRecord userRecord){
        var user = new UserModel();
        BeanUtils.copyProperties(userRecord, user);

        return userRepository.save(user);
    }

    public List<UserModel> listAllUsers(){
        return userRepository.findAll();
    }

    public Object listOneUser(UUID id){
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public Object updateUser(UUID id, UserModel userModel){
        Optional<UserModel> user = userRepository.findById(id);

        if(user.isEmpty()){
            throw new RuntimeException("user not found");
        }

        var newUser = user.get();

        newUser.setNameUser(userModel.getNameUser());
        newUser.setCpfUser(userModel.getCpfUser());
        newUser.setEmail(userModel.getEmail());

        return userRepository.save(newUser);
    }

    public Object updatePasswordtheUser(UUID id, String password){
        Optional<UserModel> user = userRepository.findById(id);

        if(user.isEmpty()){
            throw new RuntimeException("user not found");
        }

        var newUser = user.get();

        newUser.setPassword(password);

        return userRepository.save(newUser);
    }

    public void deleteAllUser(){
        userRepository.deleteAll();
    }

    public void deleteOneUser(UUID id){
        Optional<UserModel> user = userRepository.findById(id);

        if(user.isEmpty()){
            throw new RuntimeException("User not found");
        }

        userRepository.delete(user.get());
    }
}
