package com.epam.dao.dto;

import com.epam.dto.MarkDto;
import com.epam.dto.NoteDto;
import com.epam.dto.UserDto;

import java.util.List;

public interface MarkDaoDto {
    MarkDto save(MarkDto markDto);

    MarkDto findById(Long id);

    void delete(MarkDto markDto);

    List<MarkDto> findAllByNoteId(NoteDto noteDto);

    List<MarkDto> findAllByUserId(UserDto userDto);
}
