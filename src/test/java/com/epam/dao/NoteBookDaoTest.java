package com.epam.dao;

import com.epam.TestJpaConfig;
import com.epam.entity.NoteBookEntity;
import com.epam.entity.UserEntity;
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
public class NoteBookDaoTest {

    @Autowired
    private NoteBookDao noteBookDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private TestEntityBuilder testEntityBuilder;

    @Test
    public void saveTest() throws Exception {
        NoteBookEntity noteBookEntity = testEntityBuilder.initNoteBook();

        Optional<UserEntity> userEntity = userDao.findById(1L);
        noteBookEntity.setUser(userEntity.get());

        NoteBookEntity noteBookEntity1 = noteBookDao.save(noteBookEntity);

        assertTrue(noteBookEntity1.getId() != 0);
    }

    @Test
    public void updateTest() throws Exception {
        long savedNoteBookId = 1L;

        NoteBookEntity noteBookEntity = new NoteBookEntity();

        noteBookEntity.setId(savedNoteBookId);
        noteBookEntity.setName("not default");

        LocalDateTime dateTime = LocalDateTime.of(2017, 11, 1, 20, 37, 25);
        noteBookEntity.setCreateDate(ZonedDateTime.of(dateTime, ZoneId.systemDefault()));

        NoteBookEntity noteBookEntity1 = noteBookDao.save(noteBookEntity);

        Optional<NoteBookEntity> byId = noteBookDao.findById(savedNoteBookId);

        assertTrue(byId.isPresent());
        assertEquals(byId.get(), noteBookEntity1);

    }

    @Test
    public void read() throws Exception {
        Long savedNoteBookId = 1L;

        Optional<NoteBookEntity> byId = noteBookDao.findById(savedNoteBookId);

        assertTrue(byId.isPresent());
    }

    @Test
    public void deleteTest() throws Exception {
        Long savedNoteBookId = 3L;
        NoteBookEntity forDeletion = new NoteBookEntity();
        forDeletion.setId(savedNoteBookId);
        noteBookDao.delete(forDeletion);

        Optional<NoteBookEntity> deleted = noteBookDao.findById(savedNoteBookId);

        assertTrue(!deleted.isPresent());
    }
}