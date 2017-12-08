package com.epam;

import com.epam.dao.MarkDao;
import com.epam.dao.NoteBookDao;
import com.epam.dao.NoteDao;
import com.epam.dao.UserDao;
import com.epam.entity.MarkEntity;
import com.epam.entity.NoteBookEntity;
import com.epam.entity.NoteEntity;
import com.epam.entity.UserEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Optional;

import static org.junit.Assert.assertEquals;


@Transactional
public class InMemoryDBIntegrationTest {
    @Autowired
    private UserDao userRepository;

    @Autowired
    private NoteBookDao noteBookRepository;

    @Autowired
    private NoteDao noteRepository;

    @Autowired
    private MarkDao markRepository;

    @Before
    public void before(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(TestJpaConfig.class);
        context.refresh();
    }

    @Test
    public void givenUser_whenSave_thenGetOk() {
        UserEntity user1 = new UserEntity();
        user1.setId(1);
        user1.setFirstName("Ivan");
        user1.setLastName("Ivanov");
        user1.setEmail("ivanov@gmail.com");
        user1.setPassword("123");

        userRepository.save(user1);

        Optional<UserEntity> user2 = userRepository.findById(1L);
        assertEquals("first name is incorrect", "Ivan", user2.get().getFirstName());
        assertEquals("last name is incorrect", "Ivanov", user2.get().getLastName());
        assertEquals("email is incorrect", "ivanov@gmail.com", user2.get().getEmail());
        assertEquals("password is incorrect", "123", user2.get().getPassword());

    }

    @Test
    public void givenNoteBook_whenSave_thenGetOk() {
        NoteBookEntity noteBook1 = new NoteBookEntity();
        noteBook1.setId(1);
        noteBook1.setName("Note book 1");
        noteBook1.setCreateDate(new Date());

        noteBookRepository.save(noteBook1);

        Optional<NoteBookEntity> noteBook2 = noteBookRepository.findById(1L);
        assertEquals("note book name is incorrect", "Note book 1", noteBook2.get().getName());
        assertEquals("date is incorrect", noteBook1.getCreateDate(), noteBook2.get().getCreateDate());

    }

    @Test
    public void givenNote_whenSave_thenGetOk() {
        NoteEntity note1 = new NoteEntity();
        note1.setId(1);
        note1.setTitle("Note 1");
        note1.setDescription("Some description");
        note1.setCreateDate(new Date());

        noteRepository.save(note1);

        Optional<NoteEntity> note2 = noteRepository.findById(1L);
        assertEquals("note title name is incorrect", "Note 1", note2.get().getTitle());
        assertEquals("description is incorrect", "Some description", note2.get().getDescription());
        assertEquals("date is incorrect", note1.getCreateDate(), note2.get().getCreateDate());

    }

    @Test
    public void givenMark_whenSave_thenGetOk() {
        MarkEntity mark1 = new MarkEntity();
        mark1.setId(1);
        mark1.setName("Mark 1");

        markRepository.save(mark1);

        Optional<NoteBookEntity> noteBook2 = noteBookRepository.findById(1L);
        assertEquals("note book name is incorrect", "Mark", noteBook2.get().getName());

    }

}
