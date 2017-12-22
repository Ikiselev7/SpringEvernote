package com.epam.controllers.controllerMap;

import com.epam.controllers.ControllerModels.NoteBookModel;
import com.epam.dao.entity.NoteBook;

public interface NoteBookTransformer extends Transformer<NoteBook, NoteBookModel> {
    @Override
    NoteBook bind(NoteBookModel noteBookModel);

    @Override
    NoteBookModel unbind(NoteBook noteBook);
}
