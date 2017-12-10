package com.epam.mappers;

import com.epam.dto.NoteDTO;
import com.epam.entity.NoteEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public class NoteMapper {
    NoteDTO noteToNoteDto(NoteEntity note);

    List<NoteDTO> notesToNotesDto(List<NoteEntity> notes);

    NoteEntity noteDtoToNote(NoteDTO note);

    List<NoteEntity> notesDtoToNotes(List<NoteDTO> notes);
}
