package com.epam.services;

import com.epam.dao.entity.Mark;
import com.epam.dao.entity.Note;
import com.epam.dao.entity.User;


import java.util.List;
import java.util.Optional;

public interface MarkService {
    /**
     * Create mark.
     *
     * @param mark mark data
     * @return mark entity
     */
    Mark save(Mark mark);

    /**
     * Update note.
     *
     *
     * @param mark
     * @return updated data
     */
    Mark update(Mark mark);

    /**
     * Read mark data.
     *
     * @param id note id
     * @return note
     */
    Optional<Mark> read(Long id);

    /**
     * Delete mark.
     *
     * @param mark
     */
    void delete(Mark mark);

    /**
     * Return all marks from note.
     *
     * @param note note
     * @return list of notes
     */
    List<Mark> getAllByNote(Note note);

    /**
     * Return all by user.
     *
     * @param user user
     * @return list of notes
     */
    List<Mark> getAllMarkByUser(User user);
}
