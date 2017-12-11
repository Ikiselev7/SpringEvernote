package com.epam.dao.mappers;

import com.epam.models.MarkDto;
import com.epam.dao.entity.Mark;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MarkMapper {

    MarkMapper INSTANCE = Mappers.getMapper( MarkMapper.class );

    MarkDto markToMarkDto(Mark mark);

    List<MarkDto> marksToMarksDto(List<Mark> marks);

    Mark markDtoToMark(MarkDto mark);

    List<Mark> marksDtoToMarks(List<MarkDto> marks);
}
