package com.epam.controllers;

import com.epam.controllers.ControllerModels.NoteBookModel;
import com.epam.controllers.controllerMap.NoteBookTransformer;
import com.epam.dao.entity.NoteBook;
import com.epam.dao.entity.User;
import com.epam.services.NoteBookService;
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
public class NoteBookController {
    @Autowired
    private NoteBookService notebookService;
    @Autowired
    private UserService userService;
    @Autowired
    private NoteBookTransformer notebookTransformer;

    @PostMapping(value = "/notebook")
    public ResponseEntity<NoteBookModel> saveNoteBook(@RequestBody NoteBookModel notebookModel) {
        return new ResponseEntity<>(notebookTransformer
                .unbind(notebookService.
                        save(notebookTransformer
                                .bind(notebookModel))),
                HttpStatus.OK);
    }

    @GetMapping(value = "/notebook/{id}")
    public ResponseEntity<NoteBookModel> getNotebookById(@PathVariable("id") Long id) {
        NoteBook notebookDto = notebookService.read(id)
                .orElseThrow(
                        () -> new IllegalArgumentException("Bad notebook id " + id)
                );
        NoteBookModel notebookModel = notebookTransformer.unbind(notebookDto);
        return new ResponseEntity<>(notebookModel, HttpStatus.OK);
    }

    @GetMapping(value = "/user/{id}/notebooks")
    public ResponseEntity<List<NoteBookModel>> getNotesbooksByUser(@PathVariable("id") Long id) {
        User userDto = userService.read(id)
                .orElseThrow(
                        () -> new IllegalArgumentException("Bad user id " + id)
                );
        List<NoteBookModel> notebookModels = new ArrayList<>();
        for (NoteBook noteBook : notebookService.getAllByUser(userDto)) {
            notebookModels.add(notebookTransformer.unbind(noteBook));
        }
        return new ResponseEntity<>(notebookModels, HttpStatus.OK);
    }

    @PutMapping(value = "/notebook/{id}")
    public ResponseEntity<NoteBookModel> updateNoteBook(@PathVariable("id") Long id,
                                                        @RequestBody NoteBookModel notebookModel) {
        NoteBook noteBook = notebookService.read(id)
                .orElseThrow(
                        () -> new IllegalArgumentException("Bad notebook id " + id)
                );
        noteBook = notebookTransformer.bind(notebookModel);
        return new ResponseEntity<>(notebookTransformer
                .unbind(notebookService
                        .update(noteBook)),
                HttpStatus.OK);
    }

    @DeleteMapping(value = "/notebook/{id}")
    public void deleteNoteBookById(@PathVariable("id") Long id) {
        NoteBook noteBook = notebookService.read(id)
                .orElseThrow(
                        () -> new IllegalArgumentException("Bad mark id " + id)
                );
        notebookService.delete(noteBook);
    }

}
