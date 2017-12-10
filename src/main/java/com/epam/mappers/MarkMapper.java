package com.epam.mappers;

import com.epam.dto.MarkDTO;
import com.epam.entity.MarkEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public class MarkMapper {
    MarkDTO markToMarkDto(MarkEntity mark);

    List<MarkDTO> marksToMarksDto(List<MarkEntity> marks);

    MarkEntity markDtoToMark(MarkDTO mark);

    List<MarkEntity> marksDtoToMarks(List<MarkDTO> marks);
}
