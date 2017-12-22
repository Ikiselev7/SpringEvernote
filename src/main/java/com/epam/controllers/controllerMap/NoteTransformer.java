package com.epam.controllers.controllerMap;

import com.epam.controllers.ControllerModels.NoteModel;
import com.epam.dao.entity.Note;

public interface NoteTransformer extends Transformer<Note, NoteModel> {
    @Override
    Note bind(NoteModel noteModel);

    @Override
    NoteModel unbind(Note note);
}
