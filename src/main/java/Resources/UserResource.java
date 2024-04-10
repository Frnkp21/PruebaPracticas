package Resources;

import Controllers.UserController;
import DTO.UserDto;
import Entities.User;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(UserResource.USERS)
public class UserResource {
    public static final String USERS = "/users";
    @Autowired
    UserController userController;

    @GetMapping
    public ResponseEntity<List<UserDto>> users(){
        return new ResponseEntity<>(userController.readAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public  ResponseEntity<UserDto> user(@PathVariable Integer id){
        return new ResponseEntity<>(userController.getUserById(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<UserDto> newUser(@RequestBody User user){
        return ResponseEntity.ok(userController.addUser(user));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id){
        userController.removeUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Integer id, @RequestBody User updatedUser) {
        UserDto updatedUserData = userController.updateUser(id, updatedUser);

        if (updatedUserData != null) {
            return ResponseEntity.ok(updatedUserData);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PatchMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Integer id,@RequestBody Map<String, Object> updates){
        User updateUser = userController.userUpdate(id, updates);
        if (updateUser != null){
            return ResponseEntity.ok(new UserDto(updateUser));
        }return ResponseEntity.notFound().build();
    }
}