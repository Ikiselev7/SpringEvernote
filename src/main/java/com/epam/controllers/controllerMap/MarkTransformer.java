package com.epam.controllers.controllerMap;

import com.epam.controllers.ControllerModels.MarkModel;
import com.epam.dao.entity.Mark;

public interface MarkTransformer extends Transformer<Mark, MarkModel> {
    @Override
    Mark bind(MarkModel markModel);

    @Override
    MarkModel unbind(Mark mark);
}
