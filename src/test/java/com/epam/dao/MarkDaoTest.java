package com.epam.dao;

import com.epam.TestJpaConfig;
import com.epam.entity.MarkEntity;
import com.epam.entity.NoteEntity;
import com.epam.util.TestEntityBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestJpaConfig.class)
@Transactional
public class MarkDaoTest {

    @Autowired
    private NoteDao noteDao;

    @Autowired
    private MarkDao markDao;

    @Autowired
    private TestEntityBuilder testEntityBuilder;

    @Test
    public void saveTest() throws Exception {
        MarkEntity markEntity = testEntityBuilder.initMark();

        Optional<NoteEntity> noteEntity = noteDao.findById(4L);

        noteEntity.ifPresent(note -> {
            markEntity.setNotes(new HashSet<>());
            markEntity.getNotes().add(note);
            note.getMarks().add(markEntity);
        });

        MarkEntity markEntity1 = markDao.save(markEntity);

        assertTrue(markEntity1.getId() != 0);
    }

    @Test
    public void updateTest() throws Exception {
        long savedMarkId = 1L;

        MarkEntity markEntity = new MarkEntity();
        markEntity.setId(1);
        markEntity.setName("not so important");

        MarkEntity markEntity1 = markDao.save(markEntity);

        Optional<MarkEntity> byId = markDao.findById(savedMarkId);

        assertTrue(byId.isPresent());
        assertEquals(byId.get(), markEntity1);

    }

    @Test
    public void read() throws Exception {
        Long savedMarkId = 1L;

        Optional<MarkEntity> byId = markDao.findById(savedMarkId);

        assertTrue(byId.isPresent());
    }

    @Test
    public void deleteTest() throws Exception {
        Long savedMarkId = 3L;

        MarkEntity forDeletion = new MarkEntity();
        forDeletion.setId(savedMarkId);
        markDao.delete(forDeletion);

        Optional<MarkEntity> deleted = markDao.findById(savedMarkId);

        assertTrue(!deleted.isPresent());
    }

}