package com.epam.init;

import com.epam.dao.MarkDao;
import com.epam.dao.NoteBookDao;
import com.epam.dao.NoteDao;
import com.epam.dao.UserDao;
import com.epam.entity.MarkEntity;
import com.epam.entity.NoteBookEntity;
import com.epam.entity.NoteEntity;
import com.epam.entity.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;

@Service
public class DBInitializer {
    private Logger logger = LoggerFactory.getLogger(DBInitializer.class);

    @Autowired
    UserDao userRepository;

    @Autowired
    NoteBookDao noteBookRepository;

    @Autowired
    NoteDao noteRepository;

    @Autowired
    MarkDao markRepository;

    @PostConstruct
    public void init() {
        // always start with a clean database
        userRepository.deleteAll();
        logger.info("Starting database initialization...");
        UserEntity user1 = new UserEntity();
        user1.setId(1);
        user1.setFirstName("Ivan");
        user1.setLastName("Ivanov");
        user1.setEmail("ivanov@gmail.com");
        user1.setPassword("123");
        userRepository.save(user1);

        noteBookRepository.deleteAll();
        NoteBookEntity noteBook1 = new NoteBookEntity();
        noteBook1.setId(1);
        noteBook1.setName("Note book 1");
        noteBook1.setCreateDate(new Date());
        noteBookRepository.save(noteBook1);

        noteRepository.deleteAll();
        NoteEntity note1 = new NoteEntity();
        note1.setId(1);
        note1.setTitle("Note 1");
        note1.setDescription("Some description");
        note1.setCreateDate(new Date());
        noteRepository.save(note1);

        markRepository.deleteAll();
        MarkEntity mark1 = new MarkEntity();
        mark1.setId(1);
        mark1.setName("Mark 1");
        markRepository.save(mark1);

        logger.info("Database initialization finished.");
    }
}
