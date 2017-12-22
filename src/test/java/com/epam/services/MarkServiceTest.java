package com.epam.services;

import com.epam.dao.entity.Mark;
import com.epam.dao.entity.Note;
import com.epam.dao.entity.User;
import com.epam.dao.jparepositories.MarkJpaRepository;
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
    private Mark mokedMark;

    @Mock
    private Note mokedNote;

    @Mock
    private User mokedUser;

    @InjectMocks
    private MarkServiceImpl markService;

    @Mock
    private MarkJpaRepository markJpaRepository;

    @Test
    public void save() throws Exception {
        markService.save(mokedMark);
        verify(markJpaRepository).save(mokedMark);
    }

    @Test
    public void update() throws Exception {
        markService.update(mokedMark);
        verify(markJpaRepository).save(mokedMark);
    }

    @Test
    public void read() throws Exception {
        markService.read(123L);
        verify(markJpaRepository).findById(123L);
    }

    @Test
    public void delete() throws Exception {
        markService.delete(mokedMark);
        verify(markJpaRepository).delete(mokedMark);
    }

    @Test
    public void getAllByNote() throws Exception {
        markService.getAllByNote(mokedNote);
        verify(markJpaRepository).findAllByNote(mokedNote);
    }

    @Test
    public void getByMark() throws Exception {
        markService.getAllMarkByUser(mokedUser);
        verify(markJpaRepository).findAllByUser(mokedUser);
    }

}