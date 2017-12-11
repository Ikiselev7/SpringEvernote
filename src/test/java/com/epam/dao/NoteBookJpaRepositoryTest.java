package com.epam.dao;

import com.epam.TestJpaConfig;
import com.epam.dao.jparepositories.NoteBookJpaRepository;
import com.epam.dao.jparepositories.UserJpaRepository;
import com.epam.dao.entity.NoteBook;
import com.epam.dao.entity.User;
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
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestJpaConfig.class)
@Transactional
public class NoteBookJpaRepositoryTest {

    @Autowired
    private NoteBookJpaRepository noteBookJpaRepository;

    @Autowired
    private UserJpaRepository userJpaRepository;

    @Autowired
    private TestEntityBuilder testEntityBuilder;

    @Test
    public void saveTest() throws Exception {
        NoteBook noteBook = testEntityBuilder.initNoteBook();

        Optional<User> userEntity = userJpaRepository.findById(1L);
        noteBook.setUser(userEntity.get());

        NoteBook noteBook1 = noteBookJpaRepository.save(noteBook);

        assertTrue(noteBook1.getId() != 0);
    }

    @Test
    public void updateTest() throws Exception {
        long savedNoteBookId = 1L;

        NoteBook noteBook = new NoteBook();

        noteBook.setId(savedNoteBookId);
        noteBook.setName("not default");

        LocalDateTime dateTime = LocalDateTime.of(2017, 11, 1, 20, 37, 25);
        noteBook.setCreateDate(ZonedDateTime.of(dateTime, ZoneId.systemDefault()));

        NoteBook noteBook1 = noteBookJpaRepository.save(noteBook);

        Optional<NoteBook> byId = noteBookJpaRepository.findById(savedNoteBookId);

        assertTrue(byId.isPresent());
        assertEquals(byId.get(), noteBook1);

    }

    @Test
    public void read() throws Exception {
        Long savedNoteBookId = 1L;

        Optional<NoteBook> byId = noteBookJpaRepository.findById(savedNoteBookId);

        assertTrue(byId.isPresent());
    }

    @Test
    public void deleteTest() throws Exception {
        Long savedNoteBookId = 3L;
        NoteBook forDeletion = new NoteBook();
        forDeletion.setId(savedNoteBookId);
        noteBookJpaRepository.delete(forDeletion);

        Optional<NoteBook> deleted = noteBookJpaRepository.findById(savedNoteBookId);

        assertTrue(!deleted.isPresent());
    }
}