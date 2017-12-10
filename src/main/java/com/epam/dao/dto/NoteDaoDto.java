package com.epam.dao.dto;

import com.epam.dto.MarkDto;
import com.epam.dto.NoteBookDto;
import com.epam.dto.NoteDto;

import java.util.List;

public interface NoteDaoDto {
    NoteDto save(NoteDto noteDto);

    NoteDto findById(Long id);

    void delete(NoteDto noteDto);

    List<NoteDto> findAllByNoteBookId(NoteBookDto noteBookDto);

    List<NoteDto> findAllByMarkId(MarkDto markDto);
}
