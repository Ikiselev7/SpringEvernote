package com.epam.services.impl;

import com.epam.dao.entity.Mark;
import com.epam.dao.entity.Note;
import com.epam.dao.entity.User;
import com.epam.dao.jparepositories.MarkJpaRepository;
import com.epam.logging.TimeLogging;
import com.epam.services.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class MarkServiceImpl implements MarkService {
    @Autowired
    private MarkJpaRepository markJpaRepository;

    @Override
    @TimeLogging
    public Mark save(Mark mark) {
        return markJpaRepository.save(mark);
    }

    @Override
    @TimeLogging
    public Mark update(Mark mark) {
        return markJpaRepository.save(mark);
    }

    @Override
    @TimeLogging
    public Optional<Mark> read(Long id) {
        return markJpaRepository.findById(id);
    }

    @Override
    @TimeLogging
    public void delete(Mark mark) {
        markJpaRepository.delete(mark);
    }

    @Override
    @TimeLogging
    public List<Mark> getAllByNote(Note note) {
        return markJpaRepository.findAllByNote(note);
    }

    @Override
    @TimeLogging
    public List<Mark> getAllMarkByUser(User user) {
        return markJpaRepository.findAllByUser(user);
    }
}
