package com.epam.services;

import com.epam.entity.MarkEntity;
import com.epam.entity.NoteEntity;
import com.epam.entity.UserEntity;

import java.util.List;

public interface MarkService {
    /**
     * Create mark.
     *
     * @param markEntity mark data
     * @return mark entity
     */
    MarkEntity save(MarkEntity markEntity);

    /**
     * Update note.
     *
     * @param markEntity mark data
     * @return updated data
     */
    MarkEntity update(MarkEntity markEntity);

    /**
     * Read mark data.
     *
     * @param id note id
     * @return note
     */
    MarkEntity read(Long id);

    /**
     * Delete mark.
     *
     * @param markEntity mark
     */
    void delete(MarkEntity markEntity);

    /**
     * Return all notes from note.
     *
     * @param noteEntity note
     * @return list of notes
     */
    List<MarkEntity> getAllByNote(NoteEntity noteEntity);

    /**
     * Return all by user.
     *
     * @param userEntity user
     * @return list of notes
     */
    List<MarkEntity> getByMark(UserEntity userEntity);
}
