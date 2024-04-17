package com.example.Services;

import com.example.Entities.User;
import com.example.Dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    UserDAO userDAO;
    @Autowired
    public UserService(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    public List<User> readAllUsers(){
        return userDAO.findAll();
    }
    public User createUser(User user) {
        return userDAO.save(user);
    }

    public void deleteUser(Integer id) {
        userDAO.deleteById(id);
    }
}
