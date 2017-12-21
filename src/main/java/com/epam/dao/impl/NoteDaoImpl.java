package com.epam.dao.impl;

import com.epam.dao.NoteDao;
import com.epam.dao.entity.Mark;
import com.epam.dao.entity.NoteBook;
import com.epam.dao.jparepositories.NoteJpaRepository;
import com.epam.dao.mappers.MarkMapper;
import com.epam.dao.mappers.NoteBookMapper;
import com.epam.dao.mappers.NoteMapper;
import com.epam.models.MarkDto;
import com.epam.models.NoteBookDto;
import com.epam.models.NoteDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class NoteDaoImpl implements NoteDao {
    @Autowired
    private NoteJpaRepository noteJpaRepository;
    @Autowired
    private NoteMapper noteMapper;
    @Autowired
    private NoteBookMapper noteBookMapper;
    @Autowired
    private MarkMapper markMapper;


    @Override
    public NoteDto save(NoteDto noteDto) {
        return noteMapper.noteToNoteDto(noteJpaRepository.save(noteMapper.noteDtoToNote(noteDto)));
    }

    @Override
    public NoteDto findById(Long id) {
        return noteMapper.noteToNoteDto(noteJpaRepository.findById(id).get());
    }

    @Override
    public void delete(NoteDto noteDto) {
        noteJpaRepository.delete(noteMapper.noteDtoToNote(noteDto));
    }

    @Override
    public List<NoteDto> findAllByNoteBookId(NoteBookDto noteBookDto) {
        NoteBook noteBook = noteBookMapper.noteBookDtoToNoteBook(noteBookDto);
        return noteMapper.notesToNotesDto(noteJpaRepository.findAllByNoteBook(noteBook));
    }

    @Override
    public List<NoteDto> findAllByMarkId(MarkDto markDto) {
        Mark mark = markMapper.markDtoToMark(markDto);
        return noteMapper.notesToNotesDto(noteJpaRepository.findAllByMark(mark));
    }
}
