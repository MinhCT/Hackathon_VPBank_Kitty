package com.hackathon.kitty.gamification.service;

import com.hackathon.kitty.gamification.model.User;
import com.hackathon.kitty.gamification.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Page<User> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public List<User> findUsersWithSpec(Specification<User> spec) {
        return userRepository.findAll(spec);
    }

    public Page<User> findUsersWithSpec(Specification<User> spec, Pageable pageable) {
        return userRepository.findAll(spec, pageable);
    }

    @Transactional(rollbackFor={Exception.class})
    public User updateUser(User user) {
        // TODO: add checks for updating
        return userRepository.save(user);
    }

    public User createUser(User user) {
        // TODO: add checks for inserting
        return userRepository.save(user);
    }

    public User findUserById(Integer id) {
        Optional<User> user = userRepository.findById(id);
        return user.isPresent() ? user.get() : null;
    }

    public User findUserByAccountNumber(String accountNumber){
        User user = userRepository.findByAccountNumber(accountNumber);
        return user;
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }
}
