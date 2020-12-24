package com.lpnu.service.impl;

import com.lpnu.dto.UserDTO;
import com.lpnu.exception.ServiceException;
import com.lpnu.mapper.UserToUserDTOMapper;
import com.lpnu.repository.UserRepository;
import com.lpnu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserToUserDTOMapper userMapper;

    @Override
    public UserDTO getUserById(final Long id) {
        return userMapper.toDTO(userRepository.getUserById(id));
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.getAllUsers().stream()
                .map(e -> userMapper.toDTO(e))
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO createUser(final UserDTO userDTO) {

        if(userDTO.getId() != null){
            throw new ServiceException(400, "User shouldn't have an id ", null);
        }

        return userMapper.toDTO(userRepository.createUser(userMapper.toEntity(userDTO, null)));
    }

    @Override
    public UserDTO updateUser(final UserDTO userDTO) {

        if(userDTO.getId() == null){
            throw new ServiceException(400, "User should have an id ", null);
        }

        return userMapper.toDTO(userRepository.updateUser(userMapper.toEntity(userDTO, null)));
    }

    @Override
    public void deleteUserById(final Long id) {
        userRepository.deleteUserById(id);
    }
}
