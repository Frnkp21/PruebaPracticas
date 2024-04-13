package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserDAO userDAO;

    public List<User> readAllUsers(){
        return userDAO.findAll();
    }

    public User getUserById(Integer id) {
        Optional<User> optionalUser = userDAO.findById(id);
        return optionalUser.orElse(null);
    }

    public User addUser(User user) {
        return userDAO.save(user);
    }

    public void removeUser(Integer id) {
        userDAO.deleteById(id);
    }

    public User updateUser(Integer id, User updatedUser) {
        Optional<User> optionalExistingUser = userDAO.findById(id);

        if (optionalExistingUser.isPresent()) {
            User existingUser = optionalExistingUser.get();
            existingUser.setNom(updatedUser.getNom());
            return userDAO.save(existingUser);
        } else {
            return null;
        }
    }

    public User userUpdate(Integer id, Map<String,Object> updates){
        Optional<User> optionalUser = userDAO.findById(id);
        if (optionalUser.isPresent()){
            User existe = optionalUser.get();
            if (updates.containsKey("nom")) {
                existe.setNom((String) updates.get("nom"));
            }
            return userDAO.save(existe);
        }
        return null;
    }
}
