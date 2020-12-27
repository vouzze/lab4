package com.lpnu.resource;

import com.lpnu.dto.UserDTO;
import com.lpnu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@RestController
public class UserResource {
    @Autowired
    private UserService userService;

    @GetMapping("/users/{id}")
    public UserDTO getUserById(final @PathVariable Long id){
        return userService.getUserById(id);
    }

    @GetMapping("/users")
    public List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/users/{password}")
    public UserDTO createUser(final @Valid @RequestBody UserDTO userDTO, final @PathVariable String password){
        return userService.createUser(userDTO, password);
    }

    @PutMapping("/users/{password}")
    public UserDTO updateUser(final @Valid @RequestBody UserDTO userDTO, final @PathVariable String password){
        return userService.updateUser(userDTO, password);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUserById(final @PathVariable Long id){
        userService.deleteUserById(id);
    }

}
