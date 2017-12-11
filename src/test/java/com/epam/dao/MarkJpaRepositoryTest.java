package com.epam.dao;

import com.epam.TestJpaConfig;
import com.epam.dao.entity.User;
import com.epam.dao.jparepositories.MarkJpaRepository;
import com.epam.dao.jparepositories.NoteJpaRepository;
import com.epam.dao.entity.Mark;
import com.epam.dao.entity.Note;
import com.epam.dao.jparepositories.UserJpaRepository;
import com.epam.util.TestEntityBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestJpaConfig.class)
@Transactional
public class MarkJpaRepositoryTest {

    @Autowired
    private NoteJpaRepository noteJpaRepository;

    @Autowired
    private MarkJpaRepository markJpaRepository;

    @Autowired
    private UserJpaRepository userJpaRepository;

    @Autowired
    private TestEntityBuilder testEntityBuilder;

    @Test
    public void saveTest() throws Exception {
        Mark mark = testEntityBuilder.initMark();

        Optional<Note> noteEntity = noteJpaRepository.findById(4L);

        noteEntity.ifPresent(note -> {
            mark.setNotes(new HashSet<>());
            mark.getNotes().add(note);
            note.getMarks().add(mark);
        });

        Mark mark1 = markJpaRepository.save(mark);

        assertTrue(mark1.getId() != 0);
    }

    @Test
    public void updateTest() throws Exception {
        long savedMarkId = 1L;

        Mark mark = new Mark();
        mark.setId(1);
        mark.setName("not so important");

        Mark mark1 = markJpaRepository.save(mark);

        Optional<Mark> byId = markJpaRepository.findById(savedMarkId);

        assertTrue(byId.isPresent());
        assertEquals(byId.get(), mark1);

    }

    @Test
    public void read() throws Exception {
        Long savedMarkId = 1L;

        Optional<Mark> byId = markJpaRepository.findById(savedMarkId);

        assertTrue(byId.isPresent());
    }

    @Test
    public void deleteTest() throws Exception {
        Long savedMarkId = 3L;

        Mark forDeletion = new Mark();
        forDeletion.setId(savedMarkId);
        markJpaRepository.delete(forDeletion);

        Optional<Mark> deleted = markJpaRepository.findById(savedMarkId);

        assertTrue(!deleted.isPresent());
    }

    @Test
    public void findAllByNoteTest() throws Exception {
        Optional<Note> note = noteJpaRepository.findById(4L);
        List<Mark> allByNote = markJpaRepository.findAllByNote(note.orElseThrow(IllegalArgumentException::new));
        System.out.println(allByNote);
        assertTrue(allByNote.size() != 0);
    }

    @Test
    public void findAllByUserTest() throws Exception {
        Optional<User> user = userJpaRepository.findById(1L);
        List<Mark> allByUser = markJpaRepository.findAllByUser(user.orElseThrow(IllegalArgumentException::new));
        assertTrue(allByUser.size() != 0);
    }

}