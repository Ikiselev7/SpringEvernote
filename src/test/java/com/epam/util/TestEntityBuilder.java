package com.epam.util;

import com.epam.entity.MarkEntity;
import com.epam.entity.NoteBookEntity;
import com.epam.entity.NoteEntity;
import com.epam.entity.UserEntity;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Component
public class TestEntityBuilder {

    private UserEntity userEntity;

    @PostConstruct
    public void init() {
        userEntity = new UserEntity();
        userEntity.setEmail("some@email.com");
        userEntity.setFirstName("SomeFirstName");
        userEntity.setLastName("SomeLastName");
        userEntity.setPassword("SomePassword123");
        userEntity.setId(0L);
        userEntity.setNoteBooks(initNoteBookSet());
        userEntity.getNoteBooks().forEach(notebook -> notebook.setUser(userEntity));

    }

    /**
     * Return full User instance.
     *
     * @return userEntity
     */
    public UserEntity getUserEntity() {
        return userEntity;
    }

    /**
     * return full Notebook instance.
     *
     * @return notebookEntity
     */
    public NoteBookEntity getNoteBookEntyty() {
        return userEntity.getNoteBooks().stream()
                .findFirst()
                .get();
    }

    /**
     * return full note instance.
     *
     * @return note instance
     */
    public NoteEntity getNoteEntity() {
        return userEntity.getNoteBooks().stream()
                .flatMap(noteBookEntity -> noteBookEntity.getNotes().stream())
                .findFirst()
                .get();
    }

    /**
     * Return full mark entity.
     *
     * @return markEntity
     */
    public MarkEntity MarkEntity() {
        return userEntity.getNoteBooks().stream()
                .flatMap(noteBookEntity -> noteBookEntity.getNotes().stream())
                .flatMap(noteEntity -> noteEntity.getMarks().stream())
                .findFirst()
                .get();
    }

    private Set<NoteBookEntity> initNoteBookSet() {
        Set<NoteBookEntity> noteBookEntities = new HashSet<>();
        noteBookEntities.add(initNoteBook());
        return noteBookEntities;
    }

    private NoteBookEntity initNoteBook() {
        NoteBookEntity noteBookEntity = new NoteBookEntity();

        noteBookEntity.setId(0L);
        noteBookEntity.setName("Default");
        noteBookEntity.setCreateDate(LocalDateTime.now());
        noteBookEntity.setNotes(initNoteSet());
        noteBookEntity.getNotes().forEach(note -> note.setNoteBook(noteBookEntity));

        return noteBookEntity;
    }

    private Set<NoteEntity> initNoteSet() {
        Set<NoteEntity> noteEntities = new HashSet<>();
        noteEntities.add(initNote());
        noteEntities.add(initNote());
        return noteEntities;
    }

    private NoteEntity initNote() {
        NoteEntity note = new NoteEntity();

        note.setTitle("SomeNote");
        note.setId(0L);
        note.setCreateDate(LocalDateTime.now());
        note.setDescription("SomeNoteText");

        note.setMarks(initMarkSet());
        note.getMarks().forEach(mark -> mark.getNotes().add(note));

        return note;
    }

    private Set<MarkEntity> initMarkSet() {
        Set<MarkEntity> markEntities = new HashSet<>();
        markEntities.add(initMark());
        return markEntities;
    }

    private MarkEntity initMark() {
        MarkEntity markEntity = new MarkEntity();

        markEntity.setId(0);
        markEntity.setName("SomeTag");
        markEntity.setNotes(new HashSet<>());

        return markEntity;
    }

}
