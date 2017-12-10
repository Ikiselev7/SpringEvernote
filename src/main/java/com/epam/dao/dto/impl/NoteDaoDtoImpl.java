package com.epam.dao.dto.impl;

import com.epam.dao.NoteDao;
import com.epam.dao.dto.NoteDaoDto;
import com.epam.dto.MarkDto;
import com.epam.dto.NoteBookDto;
import com.epam.dto.NoteDto;
import com.epam.entity.NoteBookEntity;
import com.epam.mappers.NoteBookMapper;
import com.epam.mappers.NoteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

public class NoteDaoDtoImpl implements NoteDaoDto {

    @Autowired
    private NoteDao noteDao;

    @Autowired
    private NoteMapper noteMapper;

    @Autowired
    private NoteBookMapper noteBookMapper;

    @Override
    public NoteDto save(NoteDto noteDto) {
        return null;
    }

    @Override
    public NoteDto findById(Long id) {
        return null;
    }

    @Override
    public void delete(NoteDto noteDto) {

    }

    @Override
    public List<NoteDto> findAllByNoteBookId(NoteBookDto noteBookDto) {

        throw new NotImplementedException();
    }

    @Override
    public List<NoteDto> findAllByMarkId(MarkDto markDto) {




        return null;
    }
}
