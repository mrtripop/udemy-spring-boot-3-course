package com.spring.udemy.service;

import com.spring.udemy.interfaces.IUsers;
import com.spring.udemy.model.Post;
import com.spring.udemy.model.User;
import com.spring.udemy.repository.PostRepository;
import com.spring.udemy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUsers {

    private UserRepository userRepository;
    private PostRepository postRepository;

    @Autowired
    public UserService(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User createNewUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findUserById(int id) {
        Optional<User> user = userRepository.findById(id);
        User defaultUser = new User();
        defaultUser.setId(99);
        defaultUser.setName("Default Name");
        defaultUser.setBirthDate(LocalDate.now());
        return user.orElse(defaultUser);
    }

    @Override
    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<Post> findAllPostForUser(int userId) {
        return postRepository.findAllById(Collections.singleton(userId));
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
