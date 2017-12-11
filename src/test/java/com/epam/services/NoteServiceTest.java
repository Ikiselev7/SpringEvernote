package com.epam.services;

import com.epam.dao.impl.NoteDaoImpl;
import com.epam.models.MarkDto;
import com.epam.models.NoteBookDto;
import com.epam.models.NoteDto;
import com.epam.services.impl.NoteServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class NoteServiceTest {
    @Mock
    private NoteDto mokedNote;

    @Mock
    private NoteBookDto mokedNoteBook;

    @Mock
    private MarkDto mokedMark;

    @InjectMocks
    private NoteServiceImpl noteService;

    @Mock
    private NoteDaoImpl noteDaoDto;

    @Test
    public void save() throws Exception {
        noteService.save(mokedNote);
        verify(noteDaoDto).save(mokedNote);
    }

    @Test
    public void update() throws Exception {
        noteService.update(mokedNote);
        verify(noteDaoDto).save(mokedNote);
    }

    @Test
    public void read() throws Exception {
        noteService.read(32L);
        verify(noteDaoDto).findById(32L);
    }

    @Test
    public void delete() throws Exception {
        noteService.delete(mokedNote);
        verify(noteDaoDto).delete(mokedNote);
    }

    @Test
    public void getAllByNoteBook() throws Exception {
        noteService.getAllByNoteBook(mokedNoteBook);
        verify(noteDaoDto).findAllByNoteBookId(mokedNoteBook);
    }

    @Test
    public void getByMark() throws Exception {
        noteService.getByMark(mokedMark);
        verify(noteDaoDto).findAllByMarkId(mokedMark);
    }

}