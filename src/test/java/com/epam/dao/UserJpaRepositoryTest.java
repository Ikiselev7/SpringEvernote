package com.epam.dao;

import com.epam.TestJpaConfig;
import com.epam.dao.entity.User;
import com.epam.dao.jparepositories.UserJpaRepository;
import com.epam.dao.entity.Mark;
import com.epam.dao.entity.NoteBook;
import com.epam.dao.entity.Note;
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
public class UserJpaRepositoryTest {

    @Autowired
    private UserJpaRepository userJpaRepository;

    @Autowired
    private TestEntityBuilder testEntityBuilder;

    @Test
    public void saveTest() throws Exception {
        User user = testEntityBuilder.getUser();
        User user1 = userJpaRepository.save(user);

        assertTrue(user1.getId() != 0);

    }

    @Test
    public void updateTest() throws Exception {
        long savedUserId = 2L;

        User user = new User();
        user.setId(savedUserId);
        user.setPassword("password");
        user.setLastName("Barry");
        user.setFirstName("Larry");
        user.setEmail("mail@email.com");

        User save = userJpaRepository.save(user);

        Optional<User> userDaoById = userJpaRepository.findById(savedUserId);

        assertTrue(userDaoById.isPresent());
        assertEquals(userDaoById.get(), save);

    }

    @Test
    public void read() throws Exception {
        Long savedUserId = 1L;

        Optional<User> userDaoById = userJpaRepository.findById(savedUserId);

        assertTrue(userDaoById.isPresent());

        Set<NoteBook> noteBooks = userDaoById.get().getNoteBooks();

        assertTrue(!noteBooks.isEmpty());

        for (NoteBook noteBook : noteBooks) {
            Set<Note> notes = noteBook.getNotes();
            assertTrue(!notes.isEmpty());
            for (Note note : notes) {
                Set<Mark> marks = note.getMarks();
                assertTrue(!marks.isEmpty());
                for (Mark mark : marks) {
                    assertTrue(!mark.getNotes().isEmpty());
                }
            }
        }
    }

    @Test
    public void deleteTest() throws Exception {
        Long savedUserId = 3L;
        User forDeletion = new User();
        forDeletion.setId(savedUserId);
        forDeletion.setPassword("password123");
        forDeletion.setLastName("some");
        forDeletion.setFirstName("some");
        forDeletion.setEmail("some@email.com");

        userJpaRepository.delete(forDeletion);

        Optional<User> deleted = userJpaRepository.findById(savedUserId);

        assertTrue(!deleted.isPresent());
    }




}