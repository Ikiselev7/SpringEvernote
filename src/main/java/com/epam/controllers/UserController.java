package com.epam.controllers;

import com.epam.controllers.ControllerModels.UserModel;
import com.epam.controllers.controllerMap.UserTransformer;
import com.epam.dao.entity.User;
import com.epam.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserTransformer userTransformer;

    @PostMapping(value = "/user")
    public ResponseEntity<UserModel> saveUser(@RequestBody UserModel userModel) {
        return new ResponseEntity<>(userTransformer
                .unbind(userService.
                        save(userTransformer
                                .bind(userModel))),
                HttpStatus.CREATED);
    }

    @GetMapping(value = "/user/{id}")
    public ResponseEntity<UserModel> getUserById(@PathVariable("id") Long id) {
        User user = userService.read(id)
                .orElseThrow(
                        () -> new IllegalArgumentException("Bad user id " + id)
                );
        UserModel userModel = userTransformer.unbind(user);
        return new ResponseEntity<>(userModel, HttpStatus.OK);
    }

    @GetMapping(value = "/users")
    public ResponseEntity<List<UserModel>> getUsers() {
        List<UserModel> userModels = new ArrayList<>();
        for (User user : userService.getAll()) {
            userModels.add(userTransformer.unbind(user));
        }
        return new ResponseEntity<>(userModels, HttpStatus.OK);
    }

    @PutMapping(value = "/user/{id}")
    public ResponseEntity<UserModel> updateUser(@PathVariable("id") Long id,
                                                @RequestBody UserModel userModel) {
        User userDto = userService.read(id)
                .orElseThrow(
                        () -> new IllegalArgumentException("Bad user id " + id)
                );
        userDto = userTransformer.bind(userModel);
        return new ResponseEntity<>(userTransformer
                .unbind(userService
                        .update(userDto)),
                HttpStatus.OK);
    }

    @DeleteMapping(value = "/user/{id}")
    public void deleteUserById(@PathVariable("id") Long id) {
        User userDto = userService.read(id)
                .orElseThrow(
                        () -> new IllegalArgumentException("Bad user id " + id)
                );
        userService.delete(userDto);
    }


}
