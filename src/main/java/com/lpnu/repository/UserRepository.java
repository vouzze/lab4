package com.lpnu.repository;

import com.lpnu.entity.User;
import com.lpnu.exception.ServiceException;
import com.lpnu.service.AchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserRepository {
    @Autowired
    private BookmarkRepository bookmarkRepository;
    @Autowired
    private AchievementService achievementService;

    @PostConstruct
    public void init() {
        savedUsers = new ArrayList<>();
    }

    private static Long lastId = 1L;
    private List<User> savedUsers;

    public User getUserById(final Long id) {
        return savedUsers.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "User with id: " + id + " not found ", null));
    }

    public List<User> getAllUsers() {
        return savedUsers;
    }

    public User createUser(final User user) {
        if (user.getId() != null) {
            throw new ServiceException(400, "User shouldn't have an id ", null);
        } else if (savedUsers.stream()
                .filter(e -> e.getNickname().equals(user.getNickname()))
                .findFirst()
                .orElse(null) != null) {
            throw new ServiceException(400, "User with nickname " + user.getNickname() + " already exists ", null);
        }

        ++lastId;
        user.setId(lastId);

        savedUsers.add(user);

        return user;
    }

    public User updateUser(final User user) {
        if (user.getId() == null) {
            throw new ServiceException(400, "User should have an id ", null);
        } else if (savedUsers.stream()
                .filter(e -> e.getNickname().equals(user.getNickname()) && !e.getId().equals(user.getId()))
                .findFirst()
                .orElse(null) != null) {
            throw new ServiceException(400, "User with nickname " + user.getNickname() + " already exists ", null);
        }
        final User savedUser = getUserById(user.getId());

        savedUser.setBookmarks(user.getBookmarks());
        savedUser.setBirth(user.getBirth());
        savedUser.setNickname(user.getNickname());
        savedUser.setPassword(user.getPassword());

        savedUsers.stream()
                .filter(e -> e.getId().equals(user.getId()))
                .forEach(e -> e = savedUser);

        return savedUser;
    }

    public void deleteUserById(final Long id) {
        if (id == null) {
            throw new ServiceException(400, "Id isn't specified", null);
        }

        savedUsers.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "User with id: " + id + " not found ", null));

        savedUsers = savedUsers.stream()
                .filter(e -> !e.getId().equals(id))
                .collect(Collectors.toList());

        if (achievementService.getAllBookmarksQuantityByUserId(id) != 0) {
            bookmarkRepository.deleteBookmarksByUserId(id);
        }
    }
}
