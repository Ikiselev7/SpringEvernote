package com.epam.controllers;

import com.epam.controllers.ControllerModels.MarkModel;
import com.epam.controllers.controllerMap.MarkTransformer;
import com.epam.models.MarkDto;
import com.epam.models.NoteDto;
import com.epam.models.UserDto;
import com.epam.services.MarkService;
import com.epam.services.NoteService;
import com.epam.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MarkController {
    @Autowired
    private MarkService markService;
    @Autowired
    private UserService userService;
    @Autowired
    private NoteService noteService;
    @Autowired
    private MarkTransformer markTransformer;

    @PostMapping(value = "/mark")
    public ResponseEntity<MarkModel> saveMark(@PathVariable("markModel") MarkModel markModel) {
        return new ResponseEntity<>(markTransformer
                .unbind(markService.
                        save(markTransformer
                                .bind(markModel))),
                HttpStatus.OK);
    }

    @PutMapping(value = "/mark/{id}")
    public ResponseEntity<MarkModel> updateMark(@PathVariable("id") Long id,
                                                @RequestBody MarkModel markModel) {
        MarkDto markDto = markService.read(id);
        if (markDto == null) {
            throw new IllegalArgumentException("Bad mark id " + id);
        }
        markDto = markTransformer.bind(markModel);
        return new ResponseEntity<>(markTransformer
                .unbind(markService
                        .update(markDto)),
                HttpStatus.OK);
    }

    @GetMapping(value = "/mark/{id}")
    public ResponseEntity<MarkModel> getMarkById(@PathVariable("id") Long id) {
        MarkDto markDto = markService.read(id);
        if (markDto == null) {
            throw new IllegalArgumentException("Bad mark id " + id);
        }
        MarkModel markModel = markTransformer.unbind(markDto);
        return new ResponseEntity<>(markModel, HttpStatus.OK);
    }

    @GetMapping(value = "/user/{id}/marks")
    public ResponseEntity<List<MarkModel>> getAllMarkByUser(@PathVariable("id") Long id) {
        UserDto userDto = userService.read(id);
        if (userDto == null) {
            throw new IllegalArgumentException("Bad user id " + id);
        }
        List<MarkModel> markModels = new ArrayList<>();
        for (MarkDto markDto : markService.getAllMarkByUser(userDto)) {
            markModels.add(markTransformer.unbind(markDto));
        }
        return new ResponseEntity<>(markModels, HttpStatus.OK);
    }

    @GetMapping(value = "/note/{id}/marks")
    public ResponseEntity<List<MarkModel>> getAllByNote(@PathVariable("id") Long id) {
        NoteDto noteDto = noteService.read(id);
        if (noteDto == null) {
            throw new IllegalArgumentException("Bad note id " + id);
        }
        List<MarkModel> markModels = new ArrayList<>();
        for (MarkDto markDto : markService.getAllByNote(noteDto)) {
            markModels.add(markTransformer.unbind(markDto));
        }
        return new ResponseEntity<>(markModels, HttpStatus.OK);
    }

    @DeleteMapping(value = "/mark/{id}")
    public void deleteMarkById(@PathVariable("id") Long id) {
        MarkDto markDto = markService.read(id);
        if (markDto == null) {
            throw new IllegalArgumentException("Bad mark id " + id);
        }
        markService.delete(markDto);
    }

}
