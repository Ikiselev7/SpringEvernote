package com.epam.services;

import com.epam.dao.dto.impl.NoteBookDaoDtoImpl;
import com.epam.dto.NoteBookDto;
import com.epam.dto.UserDto;
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
    private NoteBookDto mokedNoteBook;

    @Mock
    private UserDto mokedUser;

    @InjectMocks
    private NoteBookServiceImpl noteBookService;

    @Mock
    private NoteBookDaoDtoImpl noteBookDaoDto;

    @Test
    public void save() throws Exception {
        noteBookService.save(mokedNoteBook);
        verify(noteBookDaoDto).save(mokedNoteBook);
    }

    @Test
    public void update() throws Exception {
        noteBookService.update(mokedNoteBook);
        verify(noteBookDaoDto).save(mokedNoteBook);
    }

    @Test
    public void read() throws Exception {
        noteBookService.read(241L);
        verify(noteBookDaoDto).findById(241L);
    }

    @Test
    public void delete() throws Exception {
        noteBookService.delete(mokedNoteBook);
        verify(noteBookDaoDto).delete(mokedNoteBook);
    }

    @Test
    public void getAllByUser() throws Exception {
        noteBookService.getAllByUser(mokedUser);
        verify(noteBookDaoDto).findAllByUserId(mokedUser);
    }
}
