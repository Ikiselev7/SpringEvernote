package com.epam.dao.dto.impl;

import com.epam.dao.dto.NoteBookDaoDto;
import com.epam.dto.NoteBookDto;
import com.epam.dto.UserDto;

import java.util.List;

public class NoteBookDaoDtoImpl implements NoteBookDaoDto {
    @Override
    public NoteBookDto save(NoteBookDto noteBookDto) {
        return null;
    }

    @Override
    public NoteBookDto findById(Long id) {
        return null;
    }

    @Override
    public void delete(NoteBookDto noteBookDto) {

    }

    @Override
    public List<NoteBookDto> findAllByUserId(UserDto userDto) {
        return null;
    }
}
