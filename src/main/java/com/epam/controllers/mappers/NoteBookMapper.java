package com.epam.controllers.mappers;

import com.epam.controllers.ControllerModels.NoteBookModel;
import com.epam.models.NoteBookDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NoteBookMapper {
    NoteBookDto noteBookModelToNoteBookDto(NoteBookModel noteBook);

    List<NoteBookDto> noteBooksModelToNoteBooksDto(List<NoteBookModel> noteBooks);

    NoteBookModel noteBookDtoToNoteBookModel(NoteBookDto noteBook);

    List<NoteBookModel> noteBooksModelDtoToNoteBooks(List<NoteBookDto> noteBooks);
}
