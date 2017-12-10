package com.epam.services;

import com.epam.entity.MarkEntity;
import com.epam.entity.NoteBookEntity;
import com.epam.entity.NoteEntity;

import java.util.List;

public interface NoteService {
    /**
     * Create Note.
     *
     * @param noteEntity note data
     * @return note entity
     */
    NoteEntity save(NoteEntity noteEntity);

    /**
     * Update note.
     *
     * @param noteEntity note data
     * @return updated data
     */
    NoteEntity update(NoteEntity noteEntity);

    /**
     * Read note data.
     *
     * @param id note id
     * @return note
     */
    NoteEntity read(Long id);

    /**
     * Delete note.
     *
     * @param noteEntity note
     */
    void delete(NoteEntity noteEntity);

    /**
     * Return all notes from notebook.
     *
     * @param noteBookEntity notebook
     * @return list of notes
     */
    List<NoteEntity> getAllByNoteBook(NoteBookEntity noteBookEntity);

    /**
     * Return all by mark.
     *
     * @param markEntity mark
     * @return list of notes
     */
    List<NoteEntity> getByMark(MarkEntity markEntity);
}
