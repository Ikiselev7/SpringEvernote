package com.epam.dao;

import com.epam.models.NoteBookDto;
import com.epam.models.UserDto;

import java.util.List;

public interface NoteBookDao {
    NoteBookDto save(NoteBookDto noteBookDto);

    NoteBookDto findById(Long id);

    void delete(NoteBookDto noteBookDto);

    List<NoteBookDto> findAllByUser(UserDto userDto);
}
