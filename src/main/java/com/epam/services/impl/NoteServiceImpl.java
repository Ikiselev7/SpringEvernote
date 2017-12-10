package com.epam.services.impl;

import com.epam.dao.dto.NoteDaoDto;
import com.epam.dto.MarkDto;
import com.epam.dto.NoteBookDto;
import com.epam.dto.NoteDto;
import com.epam.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteDaoDto noteDaoDto;

    @Override
    public NoteDto save(NoteDto noteDto) {
        return noteDaoDto.save(noteDto);
    }

    @Override
    public NoteDto update(NoteDto noteDto) {
        return noteDaoDto.save(noteDto);
    }

    @Override
    public NoteDto read(Long id) {
        return noteDaoDto.findById(id);
    }

    @Override
    public void delete(NoteDto noteDto) {
        noteDaoDto.delete(noteDto);
    }

    @Override
    public List<NoteDto> getAllByNoteBook(NoteBookDto noteBookDto) {
        return noteDaoDto.findAllByNoteBookId(noteBookDto);
    }

    @Override
    public List<NoteDto> getByMark(MarkDto markDto) {
        return noteDaoDto.findAllByMarkId(markDto);
    }
}
