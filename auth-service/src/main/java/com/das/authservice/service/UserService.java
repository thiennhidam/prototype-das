package com.das.authservice.service;

import com.das.authservice.model.User;
import com.das.authservice.model.UserData;
import com.das.authservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class UserService {

    @PersistenceContext
    private EntityManager em;

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public UserData getUserByEmailAndPassword(String email, String password){
        User user = userRepository.findByEmailAndPassword(email, password);
        if(user != null){
            return getUserDataFromUser(user);
        }
        return null;
    }
    private UserData getUserDataFromUser(User user){
        UserData userData = new UserData();
        userData.setId(user.getId());
        userData.setAddress(user.getAddress());
        userData.setEmail(user.getEmail());
        userData.setFirstname(user.getFirstname());
        userData.setLastname(user.getLastname());
        userData.setPhone(user.getPhone());
        return userData;
    }


}
