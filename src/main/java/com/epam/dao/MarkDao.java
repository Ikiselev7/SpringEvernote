package com.epam.dao;

import com.epam.models.MarkDto;
import com.epam.models.NoteDto;
import com.epam.models.UserDto;

import java.util.List;

public interface MarkDao {
    MarkDto save(MarkDto markDto);

    MarkDto findById(Long id);

    void delete(MarkDto markDto);

    List<MarkDto> findAllByNote(NoteDto noteDto);

    List<MarkDto> findAllByUserId(UserDto userDto);
}
