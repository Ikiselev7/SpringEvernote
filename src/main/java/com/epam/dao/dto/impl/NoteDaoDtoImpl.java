package com.epam.dao.dto.impl;

import com.epam.dao.NoteDao;
import com.epam.dao.dto.NoteDaoDto;
import com.epam.dto.MarkDto;
import com.epam.dto.NoteBookDto;
import com.epam.dto.NoteDto;
import com.epam.mappers.NoteBookMapper;
import com.epam.mappers.NoteMapper;
import lombok.RequiredArgsConstructor;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

@RequiredArgsConstructor
public class NoteDaoDtoImpl implements NoteDaoDto {
    private final NoteDao noteDao;
    private final NoteMapper noteMapper;
    private final NoteBookMapper noteBookMapper;

    @Override
    public NoteDto save(NoteDto noteDto) {
        return noteMapper.noteToNoteDto(noteDao.save(noteMapper.noteDtoToNote(noteDto)));
    }

    @Override
    public NoteDto findById(Long id) {
        return noteMapper.noteToNoteDto(noteDao.findById(id).get());
    }

    @Override
    public void delete(NoteDto noteDto) {
        noteDao.delete(noteMapper.noteDtoToNote(noteDto));
    }

    @Override
    public List<NoteDto> findAllByNoteBookId(NoteBookDto noteBookDto) {
        //TODO implement findAllByNoteBookId
        throw new NotImplementedException();
    }

    @Override
    public List<NoteDto> findAllByMarkId(MarkDto markDto) {
        //TODO implement findAllByMarkId
        throw new NotImplementedException();
    }
}
