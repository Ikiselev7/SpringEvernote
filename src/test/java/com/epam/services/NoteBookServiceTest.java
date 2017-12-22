package com.epam.services;

import com.epam.dao.entity.NoteBook;
import com.epam.dao.entity.User;
import com.epam.dao.jparepositories.NoteBookJpaRepository;
import com.epam.services.impl.NoteBookServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class NoteBookServiceTest {
    @Mock
    private NoteBook mokedNoteBook;

    @Mock
    private User mokedUser;

    @InjectMocks
    private NoteBookServiceImpl noteBookService;

    @Mock
    private NoteBookJpaRepository noteBookJpaRepository;

    @Test
    public void save() throws Exception {
        noteBookService.save(mokedNoteBook);
        verify(noteBookJpaRepository).save(mokedNoteBook);
    }

    @Test
    public void update() throws Exception {
        noteBookService.update(mokedNoteBook);
        verify(noteBookJpaRepository).save(mokedNoteBook);
    }

    @Test
    public void read() throws Exception {
        noteBookService.read(241L);
        verify(noteBookJpaRepository).findById(241L);
    }

    @Test
    public void delete() throws Exception {
        noteBookService.delete(mokedNoteBook);
        verify(noteBookJpaRepository).delete(mokedNoteBook);
    }

    @Test
    public void getAllByUser() throws Exception {
        noteBookService.getAllByUser(mokedUser);
        verify(noteBookJpaRepository).findAllByUser(mokedUser);
    }
}
