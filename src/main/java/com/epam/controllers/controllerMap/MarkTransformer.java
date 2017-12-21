package com.epam.controllers.controllerMap;

import com.epam.controllers.ControllerModels.MarkModel;
import com.epam.models.MarkDto;
import com.epam.services.MarkService;
import com.epam.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class MarkTransformer implements Transformer<MarkDto, MarkModel> {
    @Autowired
    private MarkService markService;
    @Autowired
    private NoteService noteService;

    @Override
    public MarkDto bind(MarkModel markModel) {
        MarkDto markDto = markService.read(markModel.getId());
        if(markDto == null) {
            markDto = new MarkDto();
        }

        markDto.setId(0);
        markDto.setName(markModel.getName());
        markDto.setNotes(new HashSet<>(noteService.getByMark(markDto)));


        return markDto;
    }

    @Override
    public MarkModel unbind(MarkDto markDto) {
        MarkModel markModel = new MarkModel();
        markModel.setId(markDto.getId());
        markModel.setName(markDto.getName());


        return markModel;
    }
}
