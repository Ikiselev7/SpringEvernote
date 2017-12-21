package com.epam.dao.mappers;

import com.epam.models.NoteDto;
import com.epam.dao.entity.Note;
import org.mapstruct.Mapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper(componentModel = "spring")
@Transactional
public interface NoteMapper {
    NoteDto noteToNoteDto(Note note);

    List<NoteDto> notesToNotesDto(List<Note> notes);

    Note noteDtoToNote(NoteDto note);

    List<Note> notesDtoToNotes(List<NoteDto> notes);
}
