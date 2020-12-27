package com.lpnu.mapper;

import com.lpnu.dto.UserDTO;
import com.lpnu.entity.Bookmark;
import com.lpnu.entity.User;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;

@Component
public class UserToUserDTOMapper {
    public User toEntity(final UserDTO userDTO, final String password, final List<Bookmark> bookmarkList){
        final User user = new User();

        user.setId(userDTO.getId());
        user.setBirth(userDTO.getBirth());
        user.setNickname(userDTO.getNickname());
        user.setPassword(password);
        user.setBookmarks(bookmarkList);

        return user;
    }

    public UserDTO toDTO(final @Valid User user){
        final UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setBirth(user.getBirth());
        userDTO.setNickname(user.getNickname());

        return userDTO;
    }
}
