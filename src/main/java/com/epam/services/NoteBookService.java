package com.epam.services;

import com.epam.models.NoteBookDto;
import com.epam.models.UserDto;

import java.util.List;

public interface NoteBookService {
    /**
     * Create NoteBook.
     *
     * @param noteBookDto notebook data
     * @return notebook entity
     */
    NoteBookDto save(NoteBookDto noteBookDto);

    /**
     * Update notebook.
     *
     * @param noteBookDto notebook data
     * @return updated data
     */
    NoteBookDto update(NoteBookDto noteBookDto);

    /**
     * Read notebook data.
     *
     * @param id notebook id
     * @return notebook
     */
    NoteBookDto read(Long id);

    /**
     * Delete notebook.
     *
     * @param noteBookDto notebook
     */
    void delete(NoteBookDto noteBookDto);

    /**
     * Return all notebooks by user.
     *
     * @param userDto user
     * @return list of notebooks
     */
    List<NoteBookDto> getAllByUser(UserDto userDto);
}
