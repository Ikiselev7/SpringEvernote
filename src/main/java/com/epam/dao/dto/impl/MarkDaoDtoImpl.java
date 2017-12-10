package com.epam.dao.dto.impl;

import com.epam.dao.dto.MarkDaoDto;
import com.epam.dto.MarkDto;
import com.epam.dto.NoteDto;
import com.epam.dto.UserDto;

import java.util.List;

public class MarkDaoDtoImpl implements MarkDaoDto {
    @Override
    public MarkDto save(MarkDto markDto) {
        return null;
    }

    @Override
    public MarkDto findById(Long id) {
        return null;
    }

    @Override
    public void delete(MarkDto markDto) {

    }

    @Override
    public List<MarkDto> findAllByNoteId(NoteDto noteDto) {
        return null;
    }

    @Override
    public List<MarkDto> findAllByUserId(UserDto userDto) {
        return null;
    }
}
