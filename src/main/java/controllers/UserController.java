package controllers;

import Services.UserService;
import com.example.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/users1")
    public List<User> getAllUsers() {
        System.out.println("maricon");
        return userService.findAllUsers();
    }

}
