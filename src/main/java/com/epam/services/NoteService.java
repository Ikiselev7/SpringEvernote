package com.epam.services;

import com.epam.dao.entity.Mark;
import com.epam.dao.entity.Note;
import com.epam.dao.entity.NoteBook;

import java.util.List;
import java.util.Optional;

public interface NoteService {
    /**
     * Create Note.
     *
     * @param note note data
     * @return note entity
     */
    Note save(Note note);

    /**
     * Update note.
     *
     * @param note note data
     * @return updated data
     */
    Note update(Note note);

    /**
     * Read note data.
     *
     * @param id note id
     * @return note
     */
    Optional<Note> read(Long id);

    /**
     * Delete note.
     *
     * @param note note
     */
    void delete(Note note);

    /**
     * Return all notes from notebook.
     *
     * @param noteBook notebook
     * @return list of notes
     */
    List<Note> getAllByNoteBook(NoteBook noteBook);

    /**
     * Return all by mark.
     *
     * @param mark mark
     * @return list of notes
     */
    List<Note> getByMark(Mark mark);
}
