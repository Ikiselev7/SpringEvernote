package com.epam.controllers.controllerMap;

import com.epam.controllers.ControllerModels.MarkModel;
import com.epam.dao.entity.Mark;
import com.epam.services.MarkService;
import com.epam.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;

@Service
@Transactional
public class MarkTransformerImpl implements MarkTransformer {
    @Autowired
    private MarkService markService;
    @Autowired
    private NoteService noteService;

    @Override
    public Mark bind(MarkModel markModel) {
        Mark mark = markService.read(markModel.getId())
                .orElse(new Mark());
        mark.setId(0);
        mark.setName(markModel.getName());
        mark.setNotes(new HashSet<>(noteService.getByMark(mark)));
        return mark;
    }

    @Override
    public MarkModel unbind(Mark mark) {
        MarkModel markModel = new MarkModel();
        markModel.setId(mark.getId());
        markModel.setName(mark.getName());
        return markModel;
    }
}
