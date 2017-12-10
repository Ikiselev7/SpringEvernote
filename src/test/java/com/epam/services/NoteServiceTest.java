package com.epam.services;

import com.epam.dao.dto.impl.NoteDaoDtoImpl;
import com.epam.dto.MarkDto;
import com.epam.dto.NoteBookDto;
import com.epam.dto.NoteDto;
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
    private NoteDaoDtoImpl noteDaoDto;

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