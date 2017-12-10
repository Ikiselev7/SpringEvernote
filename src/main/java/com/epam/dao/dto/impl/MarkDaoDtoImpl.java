package com.epam.dao.dto.impl;

import com.epam.dao.MarkDao;
import com.epam.dao.dto.MarkDaoDto;
import com.epam.dto.MarkDto;
import com.epam.dto.NoteDto;
import com.epam.dto.UserDto;
import com.epam.mappers.MarkMapper;
import lombok.RequiredArgsConstructor;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

@RequiredArgsConstructor
public class MarkDaoDtoImpl implements MarkDaoDto {
    private final MarkDao markDao;
    private final MarkMapper markMapper;

    @Override
    public MarkDto save(MarkDto markDto) {
        return markMapper.markToMarkDto(markDao.save(markMapper.markDtoToMark(markDto)));
    }

    @Override
    public MarkDto findById(Long id) {
        return markMapper.markToMarkDto(markDao.findById(id).get());
    }

    @Override
    public void delete(MarkDto markDto) {
        markDao.delete(markMapper.markDtoToMark(markDto));
    }

    @Override
    public List<MarkDto> findAllByNoteId(NoteDto noteDto) {
        //TODO implement findAllByNoteId
        throw new NotImplementedException();
    }

    @Override
    public List<MarkDto> findAllByUserId(UserDto userDto) {
        //TODO implement findAllByUserId
        throw new NotImplementedException();
    }
}
