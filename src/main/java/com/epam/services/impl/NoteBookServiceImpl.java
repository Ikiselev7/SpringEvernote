package com.epam.services.impl;

import com.epam.dao.NoteBookDao;
import com.epam.models.NoteBookDto;
import com.epam.models.UserDto;
import com.epam.services.NoteBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class NoteBookServiceImpl implements NoteBookService {
    @Autowired
    private NoteBookDao noteBookDao;

    @Override
    public NoteBookDto save(NoteBookDto noteBookDto) {
        return noteBookDao.save(noteBookDto);
    }

    @Override
    public NoteBookDto update(NoteBookDto noteBookDto) {
        return noteBookDao.save(noteBookDto);
    }

    @Override
    public NoteBookDto read(Long id) {
        return noteBookDao.findById(id);
    }

    @Override
    public void delete(NoteBookDto noteBookDto) {
        noteBookDao.delete(noteBookDto);
    }

    @Override
    public List<NoteBookDto> getAllByUser(UserDto userDto) {
        return noteBookDao.findAllByUser(userDto);
    }
}
