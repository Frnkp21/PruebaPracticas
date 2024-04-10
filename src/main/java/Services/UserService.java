package Services;

import DAO.UserDAO;
import Entities.User;
import DTO.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserDAO userDAO;

    public List<User> readAllUsers() {
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

    public UserDto updateUser(Integer id, User updatedUser) {
        Optional<User> optionalExistingUser = userDAO.findById(id);

        if (optionalExistingUser.isPresent()) {
            User existingUser = optionalExistingUser.get();

            existingUser.setName(updatedUser.getName());

            userDAO.save(existingUser);

            return new UserDto(existingUser);
        } else {
            return null;
        }
    }

    public User userUpdate(Integer id, Map<String, Object> updates) {
        Optional<User> optionalUser = userDAO.findById(id);
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            if (updates.containsKey("name")) {
                existingUser.setName((String) updates.get("name"));
            }
            return userDAO.save(existingUser);
        }
        return null;
    }
}
