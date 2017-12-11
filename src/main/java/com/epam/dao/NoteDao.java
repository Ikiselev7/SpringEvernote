package com.epam.dao;

import com.epam.models.MarkDto;
import com.epam.models.NoteBookDto;
import com.epam.models.NoteDto;

import java.util.List;

public interface NoteDao {
    NoteDto save(NoteDto noteDto);

    NoteDto findById(Long id);

    void delete(NoteDto noteDto);

    List<NoteDto> findAllByNoteBookId(NoteBookDto noteBookDto);

    List<NoteDto> findAllByMarkId(MarkDto markDto);
}
