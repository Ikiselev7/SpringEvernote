package com.epam.dao.dto.impl;

import com.epam.dao.dto.NoteDaoDto;
import com.epam.dto.MarkDto;
import com.epam.dto.NoteBookDto;
import com.epam.dto.NoteDto;

import java.util.List;

public class NoteDaoDtoImpl implements NoteDaoDto {
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
        return null;
    }

    @Override
    public List<NoteDto> findAllByMarkId(MarkDto markDto) {
        return null;
    }
}
