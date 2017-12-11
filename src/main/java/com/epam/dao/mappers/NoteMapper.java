package com.epam.dao.mappers;

import com.epam.models.NoteDto;
import com.epam.dao.entity.Note;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NoteMapper {
    NoteDto noteToNoteDto(Note note);

    List<NoteDto> notesToNotesDto(List<Note> notes);

    Note noteDtoToNote(NoteDto note);

    List<Note> notesDtoToNotes(List<NoteDto> notes);
}
