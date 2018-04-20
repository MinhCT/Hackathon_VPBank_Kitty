package com.hackathon.kitty.gamification.controller;

import com.hackathon.kitty.gamification.model.User;
import com.hackathon.kitty.gamification.service.UserService;
import com.hackathon.kitty.gamification.util.specification.BaseSpecificationsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/api/user")
public class UserController{

    @Autowired
    UserService userService;

    @GetMapping("")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    // Paging example:
    // http://localhost:8081/api/user?page=0&size=10&sort=id,asc
    @GetMapping("/paging")
    public ResponseEntity<Page<User>> getAllUsers(Pageable pageable) {
        return new ResponseEntity<>(userService.getAllUsers(pageable), HttpStatus.OK);
    }

    // Use this to search, for example:
    // http://localhost:8081/api/user/search?query=id:1 (other fields work too)
    @GetMapping("/search")
    public ResponseEntity<List<User>> searchUser(@RequestParam(value = "query") String query) {
        BaseSpecificationsBuilder<User> builder = new BaseSpecificationsBuilder<>();

        Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(.*?),");
        Matcher matcher = pattern.matcher(query + ",");

        while (matcher.find()) {
            builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
        }

        Specification<User> spec = builder.build();

        return new ResponseEntity<>(userService.findUsersWithSpec(spec), HttpStatus.OK);
    }

    @GetMapping("/search/paging")
    public ResponseEntity<Page<User>> searchUser(@RequestParam(value = "query") String query, Pageable pageable) {
        BaseSpecificationsBuilder<User> builder = new BaseSpecificationsBuilder<>();

        Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(.*?),");
        Matcher matcher = pattern.matcher(query + ",");

        while (matcher.find()) {
            builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
        }

        Specification<User> spec = builder.build();

        return new ResponseEntity<>(userService.findUsersWithSpec(spec, pageable), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        // TODO: add checks (for duplicate id for example -> return error message)
        // return new ResponseEntity<>("Error message", HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(userService.createUser(user), HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        // TODO: add checks (for duplicate id for example -> return error message)
        // return new ResponseEntity<>("Error message", HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(userService.updateUser(user), HttpStatus.OK);
    }

    @DeleteMapping("")
    public ResponseEntity<?> deleteUser(@RequestBody User user) {
        // TODO: add checks (for duplicate id for example -> return error message)
        // return new ResponseEntity<>("Error message", HttpStatus.BAD_REQUEST);

        userService.deleteUser(user);

        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticateUser(@RequestBody User user){
        System.out.println(user.getAccountNumber() + "abc");

        User user1 = userService.findUserByAccountNumber(user.getAccountNumber());
        if (user1.getPassword().equals(user.getPassword())){
            return new ResponseEntity<>(user1, HttpStatus.OK);
        } else { 
            return new ResponseEntity<>("Wrong username or password", HttpStatus.BAD_REQUEST);
        }
    }
}
