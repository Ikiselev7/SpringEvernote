package com.epam.controllers.controllerMap;

import com.epam.controllers.ControllerModels.NoteModel;
import com.epam.models.NoteBookDto;
import com.epam.models.NoteDto;
import com.epam.services.NoteBookService;
import com.epam.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
public class NoteTransformer implements Transformer<NoteDto, NoteModel> {
    @Autowired
    private NoteService noteService;
    @Autowired
    private NoteBookService noteBookService;


    @Override
    public NoteDto bind(NoteModel noteModel) {
        NoteDto noteDto = noteService.read(noteModel.getId());
        if (noteDto == null) {
            noteDto = new NoteDto();
            noteDto.setCreateDate(ZonedDateTime.now());
            noteDto.setId(0);
        }
        noteDto.setDescription(noteModel.getDescription());
        NoteBookDto noteBookDto = noteBookService.read(noteModel.getNoteBookId());
        noteDto.setNoteBook(noteBookDto);
        noteDto.setTitle(noteModel.getTitle());

        return noteDto;
    }

    @Override
    public NoteModel unbind(NoteDto noteDto) {
        NoteModel noteModel = new NoteModel();
        noteModel.setId(noteDto.getId());
        noteModel.setCreateDate(noteDto.getCreateDate().toString());
        noteModel.setDescription(noteDto.getDescription());
        noteModel.setTitle(noteDto.getTitle());
        noteModel.setNoteBookId(noteDto.getNoteBook().getId());

        return noteModel;
    }
}
