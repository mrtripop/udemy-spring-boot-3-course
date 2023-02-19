package com.spring.udemy.interfaces;

import com.spring.udemy.model.Post;
import com.spring.udemy.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface IUsers {
    List<User> findAllUser();

    User createNewUser(User user);

    User findUserById(int id);

    void deleteUserById(int id);

    List<Post> findAllPostForUser(int userId);

    Post savePostForUser(int userId, Post post);

    Post findOnePostForUser(int userId, int postId);
}
