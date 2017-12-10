package com.epam.dao;

import com.epam.TestJpaConfig;
import com.epam.entity.NoteBookEntity;
import com.epam.entity.NoteEntity;
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
public class NoteDaoTest {

    @Autowired
    private NoteDao noteDao;

    @Autowired
    private NoteBookDao noteBookDao;

    @Autowired
    private TestEntityBuilder testEntityBuilder;

    @Test
    public void saveTest() throws Exception {
        NoteEntity noteEntity = testEntityBuilder.initNote();

        Optional<NoteBookEntity> noteBookEntity = noteBookDao.findById(4L);

        noteBookEntity.ifPresent(noteEntity::setNoteBook);

        NoteEntity noteEntity1 = noteDao.save(noteEntity);

        assertTrue(noteEntity1.getId() != 0);
    }

    @Test
    public void updateTest() throws Exception {
        long savedNoteId = 1L;

        NoteEntity noteEntity = new NoteEntity();
        noteEntity.setId(savedNoteId);
        noteEntity.setTitle("New Title");
        noteEntity.setDescription("new description");

        LocalDateTime dateTime = LocalDateTime.of(2017, 11, 1, 20, 37, 25);
        noteEntity.setCreateDate(ZonedDateTime.of(dateTime, ZoneId.systemDefault()));

        NoteEntity noteEntity1 = noteDao.save(noteEntity);

        Optional<NoteEntity> byId = noteDao.findById(savedNoteId);

        assertTrue(byId.isPresent());
        assertEquals(byId.get(), noteEntity1);

    }

    @Test
    public void read() throws Exception {
        Long savedNoteId = 1L;

        Optional<NoteEntity> byId = noteDao.findById(savedNoteId);

        assertTrue(byId.isPresent());
    }

    @Test
    public void deleteTest() throws Exception {
        Long savedNoteId = 5L;
        NoteEntity forDeletion = new NoteEntity();
        forDeletion.setId(savedNoteId);
        noteDao.delete(forDeletion);

        Optional<NoteEntity> deleted = noteDao.findById(savedNoteId);

        assertTrue(!deleted.isPresent());
    }

}