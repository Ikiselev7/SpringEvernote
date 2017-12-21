package com.epam.services.impl;

import com.epam.dao.NoteDao;
import com.epam.models.MarkDto;
import com.epam.models.NoteBookDto;
import com.epam.models.NoteDto;
import com.epam.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteDao noteDao;

    @Override
    public NoteDto save(NoteDto noteDto) {
        return noteDao.save(noteDto);
    }

    @Override
    public NoteDto update(NoteDto noteDto) {
        return noteDao.save(noteDto);
    }

    @Override
    public NoteDto read(Long id) {
        return noteDao.findById(id);
    }

    @Override
    public void delete(NoteDto noteDto) {
        noteDao.delete(noteDto);
    }

    @Override
    public List<NoteDto> getAllByNoteBook(NoteBookDto noteBookDto) {
        return noteDao.findAllByNoteBookId(noteBookDto);
    }

    @Override
    public List<NoteDto> getByMark(MarkDto markDto) {
        return noteDao.findAllByMarkId(markDto);
    }
}
