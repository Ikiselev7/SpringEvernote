package com.epam.services;

import com.epam.dto.MarkDto;
import com.epam.dto.NoteBookDto;
import com.epam.dto.NoteDto;

import java.util.List;
import java.util.Optional;

public interface NoteService {
    /**
     * Create Note.
     *
     * @param noteDto note data
     * @return note entity
     */
    NoteDto save(NoteDto noteDto);

    /**
     * Update note.
     *
     * @param noteDto note data
     * @return updated data
     */
    NoteDto update(NoteDto noteDto);

    /**
     * Read note data.
     *
     * @param id note id
     * @return note
     */
    NoteDto read(Long id);

    /**
     * Delete note.
     *
     * @param noteDto note
     */
    void delete(NoteDto noteDto);

    /**
     * Return all notes from notebook.
     *
     * @param noteBookDto notebook
     * @return list of notes
     */
    List<NoteDto> getAllByNoteBook(NoteBookDto noteBookDto);

    /**
     * Return all by mark.
     *
     * @param markDto mark
     * @return list of notes
     */
    List<NoteDto> getByMark(MarkDto markDto);
}
