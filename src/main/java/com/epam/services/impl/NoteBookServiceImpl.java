package com.epam.services.impl;

import com.epam.dao.entity.NoteBook;
import com.epam.dao.entity.User;
import com.epam.dao.jparepositories.NoteBookJpaRepository;
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
    public NoteBook save(NoteBook noteBook) {
        return noteBookJpaRepository.save(noteBook);
    }

    @Override
    public NoteBook update(NoteBook noteBook) {
        return noteBookJpaRepository.save(noteBook);
    }

    @Override
    public Optional<NoteBook> read(Long id) {
        return noteBookJpaRepository.findById(id);
    }

    @Override
    public void delete(NoteBook noteBook) {
        noteBookJpaRepository.delete(noteBook);
    }

    @Override
    public List<NoteBook> getAllByUser(User user) {
        return noteBookJpaRepository.findAllByUser(user);
    }
}
