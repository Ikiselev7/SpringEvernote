package com.epam.controllers.api;

import com.epam.models.UserDto;
import com.epam.services.MarkService;
import com.epam.services.NoteBookService;
import com.epam.services.NoteService;
import com.epam.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EvernoteController {
    @Autowired
    private UserService userService;
    @Autowired
    private NoteService noteService;
    @Autowired
    private MarkService markService;
    @Autowired
    private NoteBookService noteBookService;

    @GetMapping("/users")
    public List<UserDto> getAllUsers() {
        return userService.getAll();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserDto> getUserById(
            @PathVariable(value = "id") Long userId) {
        Optional<UserDto> userDto = Optional.ofNullable(userService.read(userId));
        return userDto.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }




}
