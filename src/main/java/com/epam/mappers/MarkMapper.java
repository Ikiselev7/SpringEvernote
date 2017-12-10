package com.epam.mappers;

import com.epam.dto.MarkDto;
import com.epam.entity.MarkEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MarkMapper {
    MarkDto markToMarkDto(MarkEntity mark);

    List<MarkDto> marksToMarksDto(List<MarkEntity> marks);

    MarkEntity markDtoToMark(MarkDto mark);

    List<MarkEntity> marksDtoToMarks(List<MarkDto> marks);
}
