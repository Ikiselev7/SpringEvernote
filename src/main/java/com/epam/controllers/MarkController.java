package com.epam.controllers;

import com.epam.controllers.ControllerModels.MarkModel;
import com.epam.controllers.controllerMap.MarkTransformer;
import com.epam.dao.entity.Mark;
import com.epam.dao.entity.Note;
import com.epam.dao.entity.User;
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
    public ResponseEntity<MarkModel> saveMark(@RequestBody MarkModel markModel) {
        return new ResponseEntity<>(markTransformer
                .unbind(markService.
                        save(markTransformer
                                .bind(markModel))),
                HttpStatus.OK);
    }

    @GetMapping(value = "/mark/{id}")
    public ResponseEntity<MarkModel> getMarkById(@PathVariable("id") Long id) {
        Mark mark = markService.read(id)
                .orElseThrow(
                        () -> new IllegalArgumentException("Bad mark id " + id)
                );
        MarkModel markModel = markTransformer.unbind(mark);
        return new ResponseEntity<>(markModel, HttpStatus.OK);
    }

    @GetMapping(value = "/user/{id}/marks")
    public ResponseEntity<List<MarkModel>> getMarksByUser(@PathVariable("id") Long id) {
        User user = userService.read(id)
                .orElseThrow(
                        () -> new IllegalArgumentException("Bad user id " + id)
                );
        List<MarkModel> markModels = new ArrayList<>();
        for (Mark mark : markService.getAllMarkByUser(user)) {
            markModels.add(markTransformer.unbind(mark));
        }
        return new ResponseEntity<>(markModels, HttpStatus.OK);
    }

    @GetMapping(value = "/note/{id}/marks")
    public ResponseEntity<List<MarkModel>> getMarksByNote(@PathVariable("id") Long id) {
        Note noteDto = noteService.read(id)
                .orElseThrow(
                        () -> new IllegalArgumentException("Bad note id " + id)
                );
        List<MarkModel> markModels = new ArrayList<>();
        for (Mark mark : markService.getAllByNote(noteDto)) {
            markModels.add(markTransformer.unbind(mark));
        }
        return new ResponseEntity<>(markModels, HttpStatus.OK);
    }

    @PutMapping(value = "/mark/{id}")
    public ResponseEntity<MarkModel> updateMark(@PathVariable("id") Long id,
                                                @RequestBody MarkModel markModel) {
        Mark mark = markService.read(id)
                .orElseThrow(
                        () -> new IllegalArgumentException("Bad mark id " + id)
                );
        mark = markTransformer.bind(markModel);
        return new ResponseEntity<>(markTransformer
                .unbind(markService.update(mark)),
                HttpStatus.OK);
    }

    @DeleteMapping(value = "/mark/{id}")
    public void deleteMarkById(@PathVariable("id") Long id) {
        Mark mark = markService.read(id)
                .orElseThrow(
                        () -> new IllegalArgumentException("Bad mark id " + id)
                );
        markService.delete(mark);
    }

}
