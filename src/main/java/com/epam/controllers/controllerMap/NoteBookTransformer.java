package com.epam.controllers.controllerMap;

import com.epam.controllers.ControllerModels.NoteBookModel;
import com.epam.models.NoteBookDto;
import com.epam.services.NoteBookService;
import com.epam.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
public class NoteBookTransformer implements Transformer<NoteBookDto, NoteBookModel> {
    @Autowired
    private NoteBookService noteBookService;
    @Autowired
    private UserService userService;

    @Override
    public NoteBookDto bind(NoteBookModel noteBookModel) {
        NoteBookDto noteBookDto = noteBookService.read(noteBookModel.getId());
        if (noteBookDto == null){
            noteBookDto = new NoteBookDto();
            noteBookDto.setCreateDate(ZonedDateTime.now());
            noteBookDto.setId(0);
        }

        noteBookDto.setName(noteBookModel.getName());
        noteBookDto.setUser(userService.read(noteBookModel.getId()));

        return noteBookDto;
    }

    @Override
    public NoteBookModel unbind(NoteBookDto noteBookDto) {
        final NoteBookModel noteBookModel = new NoteBookModel();
        noteBookModel.setId(noteBookDto.getId());
        noteBookModel.setCreateDate(noteBookDto.getCreateDate().toString());
        noteBookModel.setName(noteBookDto.getName());
        noteBookModel.setUserId(noteBookDto.getUser().getId());

        return noteBookModel;
    }
}
