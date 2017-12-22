package com.epam.services.impl;

import com.epam.dao.entity.NoteBook;
import com.epam.dao.entity.User;
import com.epam.dao.jparepositories.NoteBookJpaRepository;
import com.epam.logging.TimeLogging;
import com.epam.services.NoteBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class NoteBookServiceImpl implements NoteBookService {
    @Autowired
    private NoteBookJpaRepository noteBookJpaRepository;

    @Override
    @TimeLogging
    public NoteBook save(NoteBook noteBook) {
        return noteBookJpaRepository.save(noteBook);
    }

    @Override
    @TimeLogging
    public NoteBook update(NoteBook noteBook) {
        return noteBookJpaRepository.save(noteBook);
    }

    @Override
    @TimeLogging
    public Optional<NoteBook> read(Long id) {
        return noteBookJpaRepository.findById(id);
    }

    @Override
    @TimeLogging
    public void delete(NoteBook noteBook) {
        noteBookJpaRepository.delete(noteBook);
    }

    @Override
    @TimeLogging
    public List<NoteBook> getAllByUser(User user) {
        return noteBookJpaRepository.findAllByUser(user);
    }
}
