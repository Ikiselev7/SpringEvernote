package com.epam.mappers;

import com.epam.dto.NoteDto;
import com.epam.entity.NoteEntity;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface NoteMapper {
    NoteDto noteToNoteDto(NoteEntity note);

    List<NoteDto> notesToNotesDto(List<NoteEntity> notes);

    NoteEntity noteDtoToNote(NoteDto note);

    List<NoteEntity> notesDtoToNotes(List<NoteDto> notes);
}
