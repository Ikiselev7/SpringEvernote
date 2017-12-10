package com.epam.dao.dto.impl;

import com.epam.dao.NoteBookDao;
import com.epam.dao.dto.NoteBookDaoDto;
import com.epam.dto.NoteBookDto;
import com.epam.dto.UserDto;
import com.epam.mappers.NoteBookMapper;
import lombok.RequiredArgsConstructor;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

@RequiredArgsConstructor
public class NoteBookDaoDtoImpl implements NoteBookDaoDto {
    private final NoteBookDao noteBookDao;
    private final NoteBookMapper noteBookMapper;

    @Override
    public NoteBookDto save(NoteBookDto noteBookDto) {
        return noteBookMapper.noteBookToNoteBookDto(noteBookDao
                .save(noteBookMapper.noteBookDtoToNoteBook(noteBookDto)));
    }

    @Override
    public NoteBookDto findById(Long id) {
        return noteBookMapper.noteBookToNoteBookDto(noteBookDao.findById(id).get());
    }

    @Override
    public void delete(NoteBookDto noteBookDto) {
        noteBookDao.delete(noteBookMapper.noteBookDtoToNoteBook(noteBookDto));
    }

    @Override
    public List<NoteBookDto> findAllByUserId(UserDto userDto) {
        //TODO implement findAllByUserId
        throw new NotImplementedException();
    }
}
