package Controllers;

import DTO.UserDto;
import Entities.User;
import Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    public List<UserDto> readAll() {
        return userService.readAllUsers().stream()
                .map(UserDto::new)
                .collect(Collectors.toList());
    }

    public UserDto getUserById(Integer id) {
        User user = userService.getUserById(id);
        if (user != null) {
            return new UserDto(user);
        } else {
            return null; // Puedes ajustar el manejo de errores según tus necesidades
        }
    }

    public UserDto addUser(User user) {
        User newUser = userService.addUser(user);
        return new UserDto(newUser);
    }

    public void removeUser(Integer id) {
        userService.removeUser(id);
    }

    public UserDto updateUser(Integer id, User updatedUser) {
        UserDto updatedUserData = userService.updateUser(id, updatedUser);

        if (updatedUserData != null) {
            return updatedUserData;
        } else {
            return null; // Puedes ajustar el manejo de errores según tus necesidades
        }
    }

    public User userUpdate(Integer id, Map<String, Object> updates) {
        return userService.userUpdate(id, updates);
    }
}
