package com.epam.services.impl;

import com.epam.dao.dto.MarkDaoDto;
import com.epam.dto.MarkDto;
import com.epam.dto.NoteDto;
import com.epam.dto.UserDto;
import com.epam.services.MarkService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MarkServiceImpl implements MarkService {
    @Autowired
    private MarkDaoDto markDaoDto;

    @Override
    public MarkDto save(MarkDto markDto) {
        return markDaoDto.save(markDto);
    }

    @Override
    public MarkDto update(MarkDto markDto) {
        return markDaoDto.save(markDto);
    }

    @Override
    public MarkDto read(Long id) {
        return markDaoDto.findById(id);
    }

    @Override
    public void delete(MarkDto markDto) {
        markDaoDto.delete(markDto);
    }

    @Override
    public List<MarkDto> getAllByNote(NoteDto noteDto) {
        return markDaoDto.findAllByNoteId(noteDto);
    }

    @Override
    public List<MarkDto> getByMark(UserDto userDto) {
        return markDaoDto.findAllByUserId(userDto);
    }
}
