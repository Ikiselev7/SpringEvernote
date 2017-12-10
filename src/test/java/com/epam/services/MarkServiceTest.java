package com.epam.services;

import com.epam.dao.dto.impl.MarkDaoDtoImpl;
import com.epam.dto.MarkDto;
import com.epam.dto.NoteDto;
import com.epam.dto.UserDto;
import com.epam.services.impl.MarkServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MarkServiceTest {
    @Mock
    private MarkDto mokedMark;

    @Mock
    private NoteDto mokedNote;

    @Mock
    private UserDto mokedUser;

    @InjectMocks
    private MarkServiceImpl markService;

    @Mock
    private MarkDaoDtoImpl markDaoDto;

    @Test
    public void save() throws Exception {
        markService.save(mokedMark);
        verify(markDaoDto).save(mokedMark);
    }

    @Test
    public void update() throws Exception {
        markService.update(mokedMark);
        verify(markDaoDto).save(mokedMark);
    }

    @Test
    public void read() throws Exception {
        markService.read(123L);
        verify(markDaoDto).findById(123L);
    }

    @Test
    public void delete() throws Exception {
        markService.delete(mokedMark);
        verify(markDaoDto).delete(mokedMark);
    }

    @Test
    public void getAllByNote() throws Exception {
        markService.getAllByNote(mokedNote);
        verify(markDaoDto).findAllByNoteId(mokedNote);
    }

    @Test
    public void getByMark() throws Exception {
        markService.getByMark(mokedUser);
        verify(markDaoDto).findAllByUserId(mokedUser);
    }

}