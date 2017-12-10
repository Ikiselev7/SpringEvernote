package com.epam.mappers;

import com.epam.dto.MarkDto;
import com.epam.entity.MarkEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MarkMapper {

    MarkMapper INSTANCE = Mappers.getMapper( MarkMapper.class );

    MarkDto markToMarkDto(MarkEntity mark);

    List<MarkDto> marksToMarksDto(List<MarkEntity> marks);

    MarkEntity markDtoToMark(MarkDto mark);

    List<MarkEntity> marksDtoToMarks(List<MarkDto> marks);
}
