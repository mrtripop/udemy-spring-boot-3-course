package com.spring.udemy.controller;

import com.spring.udemy.interfaces.IUsers;
import com.spring.udemy.model.Post;
import com.spring.udemy.model.User;
import com.spring.udemy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UserController implements IUsers {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<User> findAllUser() {
        return userService.findAllUser();
    }

    @Override
    public User createNewUser(User user) {
        return userService.createNewUser(user);
    }

    @Override
    public User findUserById(int id) {
        return userService.findUserById(id);
    }

    @Override
    public void deleteUserById(int id) {

    }

    @Override
    public List<Post> findAllPostForUser(int userId) {
        return null;
    }

    @Override
    public Post savePostForUser(int userId, Post post) {
        return null;
    }

    @Override
    public Post findOnePostForUser(int userId, int postId) {
        return null;
    }
}
