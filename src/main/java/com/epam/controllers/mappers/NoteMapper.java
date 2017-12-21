package com.epam.controllers.mappers;

import com.epam.controllers.ControllerModels.NoteModel;
import com.epam.models.NoteDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NoteMapper {
    NoteDto noteModelToNoteDto(NoteModel note);

    List<NoteDto> notesModelToNotesDto(List<NoteModel> notes);

    NoteModel noteDtoToNoteModel(NoteDto note);

    List<NoteModel> notesDtoToNotesModel(List<NoteDto> notes);
}
