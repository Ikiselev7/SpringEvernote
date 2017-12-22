package com.epam.services;

import com.epam.dao.entity.NoteBook;
import com.epam.dao.entity.User;

import java.util.List;
import java.util.Optional;

public interface NoteBookService {
    /**
     * Create NoteBook.
     *
     * @param noteBook
     * @return notebook entity
     */
    NoteBook save(NoteBook noteBook);

    /**
     * Update notebook.
     *
     * @param noteBook@return updated data
     */
    NoteBook update(NoteBook noteBook);

    /**
     * Read notebook data.
     *
     * @param id notebook id
     * @return notebook
     */
    Optional<NoteBook> read(Long id);

    /**
     * Delete notebook.
     *
     * @param noteBook
     */
    void delete(NoteBook noteBook);

    /**
     * Return all notebooks by user.
     *
     * @param user@return list of notebooks
     */
    List<NoteBook> getAllByUser(User user);
}
