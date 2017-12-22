package com.epam.services;

import com.epam.dao.entity.Mark;
import com.epam.dao.entity.Note;
import com.epam.dao.entity.NoteBook;
import com.epam.dao.jparepositories.NoteJpaRepository;
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
    private Note mokedNote;

    @Mock
    private NoteBook mokedNoteBook;

    @Mock
    private Mark mokedMark;

    @InjectMocks
    private NoteServiceImpl noteService;

    @Mock
    private NoteJpaRepository noteJpaRepository;

    @Test
    public void save() throws Exception {
        noteService.save(mokedNote);
        verify(noteJpaRepository).save(mokedNote);
    }

    @Test
    public void update() throws Exception {
        noteService.update(mokedNote);
        verify(noteJpaRepository).save(mokedNote);
    }

    @Test
    public void read() throws Exception {
        noteService.read(32L);
        verify(noteJpaRepository).findById(32L);
    }

    @Test
    public void delete() throws Exception {
        noteService.delete(mokedNote);
        verify(noteJpaRepository).delete(mokedNote);
    }

    @Test
    public void getAllByNoteBook() throws Exception {
        noteService.getAllByNoteBook(mokedNoteBook);
        verify(noteJpaRepository).findAllByNoteBook(mokedNoteBook);
    }

    @Test
    public void getByMark() throws Exception {
        noteService.getByMark(mokedMark);
        verify(noteJpaRepository).findAllByMark(mokedMark);
    }

}