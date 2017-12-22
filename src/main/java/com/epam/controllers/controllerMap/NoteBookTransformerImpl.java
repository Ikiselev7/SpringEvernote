package com.epam.controllers.controllerMap;

import com.epam.controllers.ControllerModels.NoteBookModel;
import com.epam.dao.entity.NoteBook;
import com.epam.services.NoteBookService;
import com.epam.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;

@Service
@Transactional
public class NoteBookTransformerImpl implements NoteBookTransformer {
    @Autowired
    private NoteBookService noteBookService;
    @Autowired
    private UserService userService;


    @Override
    public NoteBook bind(NoteBookModel noteBookModel) {
        NoteBook noteBook = noteBookService.read(noteBookModel.getId())
                .orElseGet(
                        () -> {
                            NoteBook noteBook1 = new NoteBook();
                            noteBook1.setCreateDate(ZonedDateTime.now());
                            noteBook1.setId(0);
                            return noteBook1;
                        }
                );

        noteBook.setName(noteBookModel.getName());
        noteBook.setUser(userService.read(noteBookModel.getId()).orElseThrow(
                () -> new IllegalArgumentException("User not found with id " + noteBookModel.getId())
        ));

        return noteBook;
    }

    @Override
    public NoteBookModel unbind(NoteBook noteBook) {
        final NoteBookModel noteBookModel = new NoteBookModel();
        noteBookModel.setId(noteBook.getId());
        noteBookModel.setCreateDate(noteBook.getCreateDate().toString());
        noteBookModel.setName(noteBook.getName());
        noteBookModel.setUserId(noteBook.getUser().getId());

        return noteBookModel;
    }
}
