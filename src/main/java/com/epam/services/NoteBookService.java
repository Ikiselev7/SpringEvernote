package com.epam.services;

import com.epam.entity.NoteBookEntity;
import com.epam.entity.UserEntity;

import java.util.List;

public interface NoteBookService {
    /**
     * Create NoteBook.
     *
     * @param noteBookEntity notebook data
     * @return notebook entity
     */
    NoteBookEntity save(NoteBookEntity noteBookEntity);

    /**
     * Update notebook.
     *
     * @param noteBookEntity notebook data
     * @return updated data
     */
    NoteBookEntity update(NoteBookEntity noteBookEntity);

    /**
     * Read notebook data.
     *
     * @param id notebook id
     * @return notebook
     */
    NoteBookEntity read(Long id);

    /**
     * Delete notebook.
     *
     * @param noteBookEntity notebook
     */
    void delete(NoteBookEntity noteBookEntity);

    /**
     * Return all notebooks by user.
     *
     * @param userEntity user
     * @return list of notebooks
     */
    List<NoteBookEntity> getAllByUser(UserEntity userEntity);
}
