package com.epam.dao.impl;

import com.epam.dao.entity.Note;
import com.epam.dao.entity.User;
import com.epam.dao.jparepositories.MarkJpaRepository;
import com.epam.dao.MarkDao;
import com.epam.dao.mappers.NoteMapper;
import com.epam.dao.mappers.UserMapper;
import com.epam.models.MarkDto;
import com.epam.models.NoteDto;
import com.epam.models.UserDto;
import com.epam.dao.mappers.MarkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MarkDaoImpl implements MarkDao {
    @Autowired
    private MarkJpaRepository markJpaRepository;
    @Autowired
    private MarkMapper markMapper;
    @Autowired
    private NoteMapper noteMapper;
    @Autowired
    private UserMapper userMapper;


    @Override
    public MarkDto save(MarkDto markDto) {
        return markMapper.markToMarkDto(markJpaRepository.save(markMapper.markDtoToMark(markDto)));
    }

    @Override
    public MarkDto findById(Long id) {
        return markMapper.markToMarkDto(markJpaRepository.findById(id).get());
    }

    @Override
    public void delete(MarkDto markDto) {
        markJpaRepository.delete(markMapper.markDtoToMark(markDto));
    }

    @Override
    public List<MarkDto> findAllByNote(NoteDto noteDto) {
        Note note = noteMapper.noteDtoToNote(noteDto);
        return markMapper.marksToMarksDto(markJpaRepository.findAllByNote(note));
    }

    @Override
    public List<MarkDto> findAllByUserId(UserDto userDto) {
        User user = userMapper.userDtoToUser(userDto);
        return markMapper.marksToMarksDto(markJpaRepository.findAllByUser(user));
    }
}
