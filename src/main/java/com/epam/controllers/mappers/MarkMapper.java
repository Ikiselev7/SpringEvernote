package com.epam.controllers.mappers;

import com.epam.controllers.ControllerModels.MarkModel;
import com.epam.models.MarkDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MarkMapper {
    MarkDto markModelToMarkDto(MarkModel mark);

    List<MarkDto> marksModelToMarksDto(List<MarkModel> marks);

    MarkModel markDtoToMarkModel(MarkDto mark);

    List<MarkModel> marksDtoToMarksModel(List<MarkDto> marks);
}
