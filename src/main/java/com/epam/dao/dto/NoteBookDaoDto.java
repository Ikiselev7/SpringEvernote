package com.epam.dao.dto;

import com.epam.dto.NoteBookDto;
import com.epam.dto.UserDto;

import java.util.List;

public interface NoteBookDaoDto {
    NoteBookDto save(NoteBookDto noteBookDto);

    NoteBookDto findById(Long id);

    void delete(NoteBookDto noteBookDto);

    List<NoteBookDto> findAllByUserId(UserDto userDto);
}
