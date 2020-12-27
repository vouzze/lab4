package com.lpnu.service;

import com.lpnu.dto.UserDTO;
import java.util.List;

public interface UserService {
    UserDTO getUserById(Long id);
    List<UserDTO> getAllUsers();
    UserDTO createUser(UserDTO userDTO, String password);
    UserDTO updateUser(UserDTO userDTO, String password);
    void deleteUserById(Long id);
    }
