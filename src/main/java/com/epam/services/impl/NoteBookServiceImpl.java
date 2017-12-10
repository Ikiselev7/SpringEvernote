package com.epam.services.impl;

import com.epam.dao.dto.NoteBookDaoDto;
import com.epam.dto.NoteBookDto;
import com.epam.dto.UserDto;
import com.epam.services.NoteBookService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class NoteBookServiceImpl implements NoteBookService {
    @Autowired
    private NoteBookDaoDto noteBookDaoDto;

    @Override
    public NoteBookDto save(NoteBookDto noteBookDto) {
        return noteBookDaoDto.save(noteBookDto);
    }

    @Override
    public NoteBookDto update(NoteBookDto noteBookDto) {
        return noteBookDaoDto.save(noteBookDto);
    }

    @Override
    public NoteBookDto read(Long id) {
        return noteBookDaoDto.findById(id);
    }

    @Override
    public void delete(NoteBookDto noteBookDto) {
        noteBookDaoDto.delete(noteBookDto);
    }

    @Override
    public List<NoteBookDto> getAllByUser(UserDto userDto) {
        return noteBookDaoDto.findAllByUserId(userDto);
    }
}
