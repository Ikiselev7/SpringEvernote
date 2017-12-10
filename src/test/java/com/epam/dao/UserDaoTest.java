package com.epam.dao;

import com.epam.TestJpaConfig;
import com.epam.entity.MarkEntity;
import com.epam.entity.NoteBookEntity;
import com.epam.entity.NoteEntity;
import com.epam.entity.UserEntity;
import com.epam.util.TestEntityBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestJpaConfig.class)
@Transactional
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Autowired
    private TestEntityBuilder testEntityBuilder;

    @Test
    public void saveTest() throws Exception {
        UserEntity userEntity = testEntityBuilder.getUserEntity();
        UserEntity userEntity1 = userDao.save(userEntity);

        assertTrue(userEntity1.getId() != 0);

    }

    @Test
    public void updateTest() throws Exception {
        long savedUserId = 2L;

        UserEntity userEntity = new UserEntity();
        userEntity.setId(savedUserId);
        userEntity.setPassword("password");
        userEntity.setLastName("Barry");
        userEntity.setFirstName("Larry");
        userEntity.setEmail("mail@email.com");

        UserEntity save = userDao.save(userEntity);

        Optional<UserEntity> userDaoById = userDao.findById(savedUserId);

        assertTrue(userDaoById.isPresent());
        assertEquals(userDaoById.get(), save);

    }

    @Test
    public void read() throws Exception {
        Long savedUserId = 1L;

        Optional<UserEntity> userDaoById = userDao.findById(savedUserId);

        assertTrue(userDaoById.isPresent());

        Set<NoteBookEntity> noteBooks = userDaoById.get().getNoteBooks();

        assertTrue(!noteBooks.isEmpty());

        for (NoteBookEntity noteBook : noteBooks) {
            Set<NoteEntity> notes = noteBook.getNotes();
            assertTrue(!notes.isEmpty());
            for (NoteEntity note : notes) {
                Set<MarkEntity> marks = note.getMarks();
                assertTrue(!marks.isEmpty());
                for (MarkEntity mark : marks) {
                    assertTrue(!mark.getNotes().isEmpty());
                }
            }
        }
    }

    @Test
    public void deleteTest() throws Exception {
        Long savedUserId = 3L;
        UserEntity forDeletion = new UserEntity();
        forDeletion.setId(savedUserId);
        forDeletion.setPassword("password123");
        forDeletion.setLastName("some");
        forDeletion.setFirstName("some");
        forDeletion.setEmail("some@email.com");

        userDao.delete(forDeletion);

        Optional<UserEntity> deleted = userDao.findById(savedUserId);

        assertTrue(!deleted.isPresent());
    }




}