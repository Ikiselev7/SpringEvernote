package com.epam.util;

import com.epam.dao.entity.Mark;
import com.epam.dao.entity.NoteBook;
import com.epam.dao.entity.Note;
import com.epam.dao.entity.User;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

@Component
public class TestEntityBuilder {

    private User user;

    @PostConstruct
    public void init() {
        user = new User();
        user.setEmail("some@email.com");
        user.setFirstName("SomeFirstName");
        user.setLastName("SomeLastName");
        user.setPassword("SomePassword123");
        user.setId(0L);
        user.setNoteBooks(initNoteBookSet());
        user.getNoteBooks().forEach(notebook -> notebook.setUser(user));

    }

    /**
     * Return full User instance.
     *
     * @return user
     */
    public User getUser() {
        return user;
    }

    private Set<NoteBook> initNoteBookSet() {
        Set<NoteBook> noteBookEntities = new HashSet<>();
        noteBookEntities.add(initNoteBook());
        return noteBookEntities;
    }

    /**
     * return full Notebook instance.
     *
     * @return notebookEntity
     */
    public NoteBook initNoteBook() {
        NoteBook noteBook = new NoteBook();

        noteBook.setId(0L);
        noteBook.setName("Default");
        noteBook.setCreateDate(ZonedDateTime.of(
                LocalDateTime.of(2017, 1, 1, 0, 37, 25),
                ZoneId.systemDefault()
        ));
        noteBook.setNotes(initNoteSet());
        noteBook.getNotes().forEach(note -> note.setNoteBook(noteBook));

        return noteBook;
    }

    private Set<Note> initNoteSet() {
        Set<Note> noteEntities = new HashSet<>();
        noteEntities.add(initNote());
        noteEntities.add(initNote());
        return noteEntities;
    }

    /**
     * return full note instance.
     *
     * @return note instance
     */
    public Note initNote() {
        Note note = new Note();

        note.setTitle("SomeNote");
        note.setId(0L);
        note.setCreateDate(ZonedDateTime.of(
                LocalDateTime.of(2017, 1, 1, 0, 37, 25),
                ZoneId.systemDefault()
        ));
        note.setDescription("SomeNoteText");

        note.setMarks(initMarkSet());
        note.getMarks().forEach(mark -> mark.getNotes().add(note));

        return note;
    }

    private Set<Mark> initMarkSet() {
        Set<Mark> markEntities = new HashSet<>();
        markEntities.add(initMark());
        return markEntities;
    }

    /**
     * Return full mark entity.
     *
     * @return markEntity
     */
    public Mark initMark() {
        Mark mark = new Mark();

        mark.setId(0);
        mark.setName("SomeTag");
        mark.setNotes(new HashSet<>());

        return mark;
    }

}
