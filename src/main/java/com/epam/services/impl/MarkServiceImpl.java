package com.epam.services.impl;

import com.epam.dao.MarkDao;
import com.epam.models.MarkDto;
import com.epam.models.NoteDto;
import com.epam.models.UserDto;
import com.epam.services.MarkService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MarkServiceImpl implements MarkService {
    @Autowired
    private MarkDao markDao;

    @Override
    public MarkDto save(MarkDto markDto) {
        return markDao.save(markDto);
    }

    @Override
    public MarkDto update(MarkDto markDto) {
        return markDao.save(markDto);
    }

    @Override
    public MarkDto read(Long id) {
        return markDao.findById(id);
    }

    @Override
    public void delete(MarkDto markDto) {
        markDao.delete(markDto);
    }

    @Override
    public List<MarkDto> getAllByNote(NoteDto noteDto) {
        return markDao.findAllByNote(noteDto);
    }

    @Override
    public List<MarkDto> getByMark(UserDto userDto) {
        return markDao.findAllByUserId(userDto);
    }
}