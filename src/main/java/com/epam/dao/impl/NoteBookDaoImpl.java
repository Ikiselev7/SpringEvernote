package com.epam.dao.impl;

import com.epam.dao.NoteBookDao;
import com.epam.dao.entity.User;
import com.epam.dao.jparepositories.NoteBookJpaRepository;
import com.epam.dao.mappers.NoteBookMapper;
import com.epam.dao.mappers.UserMapper;
import com.epam.models.NoteBookDto;
import com.epam.models.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class NoteBookDaoImpl implements NoteBookDao {
    @Autowired
    private NoteBookJpaRepository noteBookJpaRepository;
    @Autowired
    private NoteBookMapper noteBookMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public NoteBookDto save(NoteBookDto noteBookDto) {
        return noteBookMapper.noteBookToNoteBookDto(noteBookJpaRepository
                .save(noteBookMapper.noteBookDtoToNoteBook(noteBookDto)));
    }

    @Override
    public NoteBookDto findById(Long id) {
        return noteBookMapper.noteBookToNoteBookDto(noteBookJpaRepository.findById(id).get());
    }

    @Override
    public void delete(NoteBookDto noteBookDto) {
        noteBookJpaRepository.delete(noteBookMapper.noteBookDtoToNoteBook(noteBookDto));
    }

    @Override
    public List<NoteBookDto> findAllByUser(UserDto userDto) {
        User user = userMapper.userDtoToUser(userDto);
        return noteBookMapper.noteBooksToNoteBooksDto(noteBookJpaRepository.findAllByUser(user));
    }
}
