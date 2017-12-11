package com.epam.dao;

import com.epam.TestJpaConfig;
import com.epam.dao.entity.Mark;
import com.epam.dao.jparepositories.MarkJpaRepository;
import com.epam.dao.jparepositories.NoteBookJpaRepository;
import com.epam.dao.jparepositories.NoteJpaRepository;
import com.epam.dao.entity.NoteBook;
import com.epam.dao.entity.Note;
import com.epam.util.TestEntityBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestJpaConfig.class)
@Transactional
public class NoteJpaRepositoryTest {

    @Autowired
    private NoteJpaRepository noteJpaRepository;

    @Autowired
    private NoteBookJpaRepository noteBookJpaRepository;

    @Autowired
    private MarkJpaRepository markJpaRepository;

    @Autowired
    private TestEntityBuilder testEntityBuilder;

    @Test
    public void saveTest() throws Exception {
        Note note = testEntityBuilder.initNote();

        Optional<NoteBook> noteBookEntity = noteBookJpaRepository.findById(4L);

        noteBookEntity.ifPresent(note::setNoteBook);

        Note note1 = noteJpaRepository.save(note);

        assertTrue(note1.getId() != 0);
    }

    @Test
    public void updateTest() throws Exception {
        long savedNoteId = 1L;

        Note note = new Note();
        note.setId(savedNoteId);
        note.setTitle("New Title");
        note.setDescription("new description");

        LocalDateTime dateTime = LocalDateTime.of(2017, 11, 1, 20, 37, 25);
        note.setCreateDate(ZonedDateTime.of(dateTime, ZoneId.systemDefault()));

        Note note1 = noteJpaRepository.save(note);

        Optional<Note> byId = noteJpaRepository.findById(savedNoteId);

        assertTrue(byId.isPresent());
        assertEquals(byId.get(), note1);

    }

    @Test
    public void read() throws Exception {
        Long savedNoteId = 1L;

        Optional<Note> byId = noteJpaRepository.findById(savedNoteId);

        assertTrue(byId.isPresent());
    }

    @Test
    public void deleteTest() throws Exception {
        Long savedNoteId = 5L;
        Note forDeletion = new Note();
        forDeletion.setId(savedNoteId);
        noteJpaRepository.delete(forDeletion);

        Optional<Note> deleted = noteJpaRepository.findById(savedNoteId);

        assertTrue(!deleted.isPresent());
    }

    @Test
    public void findAllByMarkTest() throws Exception {
        Optional<Mark> mark = markJpaRepository.findById(2L);
        List<Note> allByMark = noteJpaRepository.findAllByMark(mark.orElseThrow(IllegalArgumentException::new));
        assertTrue(allByMark.size() != 0);
    }

}