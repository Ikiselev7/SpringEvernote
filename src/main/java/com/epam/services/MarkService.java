package com.epam.services;

import com.epam.models.MarkDto;
import com.epam.models.NoteDto;
import com.epam.models.UserDto;

import java.util.List;

public interface MarkService {
    /**
     * Create mark.
     *
     * @param markDto mark data
     * @return mark entity
     */
    MarkDto save(MarkDto markDto);

    /**
     * Update note.
     *
     * @param markDto mark data
     * @return updated data
     */
    MarkDto update(MarkDto markDto);

    /**
     * Read mark data.
     *
     * @param id note id
     * @return note
     */
    MarkDto read(Long id);

    /**
     * Delete mark.
     *
     * @param markDto mark
     */
    void delete(MarkDto markDto);

    /**
     * Return all notes from note.
     *
     * @param noteDto note
     * @return list of notes
     */
    List<MarkDto> getAllByNote(NoteDto noteDto);

    /**
     * Return all by user.
     *
     * @param userDto user
     * @return list of notes
     */
    List<MarkDto> getByMark(UserDto userDto);
}
