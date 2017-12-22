package com.epam.controllers.controllerMap;

import com.epam.controllers.ControllerModels.NoteModel;
import com.epam.dao.entity.Note;
import com.epam.dao.entity.NoteBook;
import com.epam.services.NoteBookService;
import com.epam.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;

@Service
@Transactional
public class NoteTransformerImpl implements NoteTransformer {
    @Autowired
    private NoteService noteService;
    @Autowired
    private NoteBookService noteBookService;


    @Override
    public Note bind(NoteModel noteModel) {
        Note note = noteService.read(noteModel.getId())
                .orElseGet(
                        () -> {
                            Note note1 = new Note();
                            note1.setCreateDate(ZonedDateTime.now());
                            note1.setId(0);
                            return note1;
                        }
                );
        note.setDescription(noteModel.getDescription());
        NoteBook noteBook = noteBookService.read(noteModel.getNoteBookId())
                .orElseThrow(
                        () -> new IllegalArgumentException("NoteBook not exist with id" + noteModel.getNoteBookId())
                );
        note.setNoteBook(noteBook);
        note.setTitle(noteModel.getTitle());

        return note;
    }

    @Override
    public NoteModel unbind(Note note) {
        NoteModel noteModel = new NoteModel();
        noteModel.setId(note.getId());
        noteModel.setCreateDate(note.getCreateDate().toString());
        noteModel.setDescription(note.getDescription());
        noteModel.setTitle(note.getTitle());
        noteModel.setNoteBookId(note.getNoteBook().getId());

        return noteModel;
    }
}
