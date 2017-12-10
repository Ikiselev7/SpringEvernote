package com.epam.util;

import com.epam.dao.UserDao;
import com.epam.entity.MarkEntity;
import com.epam.entity.NoteBookEntity;
import com.epam.entity.NoteEntity;
import com.epam.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


public class DataBaseInit {
    UserDao userRepository;


    public void init() {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail("first@email.com");
        userEntity.setFirstName("otherFirstName");
        userEntity.setLastName("otherLastName");
        userEntity.setPassword("otherPassword123");
        userEntity.setId(0L);
        userEntity.setNoteBooks(initNoteBookSet());
        userEntity.getNoteBooks().forEach(notebook -> notebook.setUser(userEntity));
        userRepository.save(userEntity);
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
