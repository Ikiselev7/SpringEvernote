package com.epam.services.impl;

import com.epam.dao.entity.Mark;
import com.epam.dao.entity.Note;
import com.epam.dao.entity.NoteBook;
import com.epam.dao.jparepositories.NoteJpaRepository;
import com.epam.logging.TimeLogging;
import com.epam.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteJpaRepository noteJpaRepository;

    @Override
    @TimeLogging
    public Note save(Note note) {
        return noteJpaRepository.save(note);
    }

    @Override
    @TimeLogging
    public Note update(Note note) {
        return noteJpaRepository.save(note);
    }

    @Override
    @TimeLogging
    public Optional<Note> read(Long id) {
        return noteJpaRepository.findById(id);
    }

    @Override
    @TimeLogging
    public void delete(Note note) {
        noteJpaRepository.delete(note);
    }

    @Override
    @TimeLogging
    public List<Note> getAllByNoteBook(NoteBook noteBook) {
        return noteJpaRepository.findAllByNoteBook(noteBook);
    }

    @Override
    @TimeLogging
    public List<Note> getByMark(Mark mark) {
        return noteJpaRepository.findAllByMark(mark);
    }
}
