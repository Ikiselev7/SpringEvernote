package com.epam.controllers;

import com.epam.controllers.ControllerModels.NoteModel;
import com.epam.controllers.controllerMap.NoteTransformer;
import com.epam.dao.entity.Mark;
import com.epam.dao.entity.Note;
import com.epam.dao.entity.NoteBook;
import com.epam.dao.entity.User;
import com.epam.services.MarkService;
import com.epam.services.NoteBookService;
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
public class NoteController {
    @Autowired
    private NoteService noteService;
    @Autowired
    private MarkService markService;
    @Autowired
    private NoteBookService notebookService;
    @Autowired
    private NoteTransformer noteTransformer;


    @PostMapping(value = "/note")
    public ResponseEntity<NoteModel> saveNote(@RequestBody NoteModel noteModel) {
        return new ResponseEntity<>(noteTransformer
                .unbind(noteService.
                        save(noteTransformer
                                .bind(noteModel))),
                HttpStatus.CREATED);
    }

    @GetMapping(value = "/note/{id}")
    public ResponseEntity<NoteModel> getNoteById(@PathVariable("id") Long id) {
        Note note = noteService.read(id)
                .orElseThrow(
                        () -> new IllegalArgumentException("Bad note id " + id)
                );
        NoteModel noteModel = noteTransformer.unbind(note);
        return new ResponseEntity<>(noteModel, HttpStatus.OK);
    }

    @GetMapping(value = "/notebook/{id}/notes")
    public ResponseEntity<List<NoteModel>> getNotesByNotebook(@PathVariable("id") Long id) {
        NoteBook noteBook = notebookService.read(id)
                .orElseThrow(
                        () -> new IllegalArgumentException("Bad notebook id " + id)
                );
        List<NoteModel> noteModels = new ArrayList<>();
        for (Note note : noteService.getAllByNoteBook(noteBook)) {
            noteModels.add(noteTransformer.unbind(note));
        }
        return new ResponseEntity<>(noteModels, HttpStatus.OK);
    }

    @GetMapping(value = "/mark/{id}/notes")
    public ResponseEntity<List<NoteModel>> getNotesByMark(@PathVariable("id") Long id) {
        Mark mark = markService.read(id)
                .orElseThrow(
                        () -> new IllegalArgumentException("Bad mark id " + id)
                );
        List<NoteModel> noteModels = new ArrayList<>();
        for (Note note : noteService.getByMark(mark)) {
            noteModels.add(noteTransformer.unbind(note));
        }
        return new ResponseEntity<>(noteModels, HttpStatus.OK);
    }

    @PutMapping(value = "/note/{id}")
    public ResponseEntity<NoteModel> updateNote(@PathVariable("id") Long id,
                                                @RequestBody NoteModel noteModel) {
        Note note = noteService.read(id)
                .orElseThrow(
                        () -> new IllegalArgumentException("Bad note id " + id)
                );
        note = noteTransformer.bind(noteModel);
        return new ResponseEntity<>(noteTransformer
                .unbind(noteService
                        .update(note)),
                HttpStatus.OK);
    }

    @DeleteMapping(value = "/note/{id}")
    public void deleteNoteById(@PathVariable("id") Long id) {
        Note note = noteService.read(id)
                .orElseThrow(
                        () -> new IllegalArgumentException("Bad note id " + id)
                );
        noteService.delete(note);
    }
}
