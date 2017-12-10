package com.epam.mappers;

import com.epam.dto.NoteBookDTO;
import com.epam.entity.NoteBookEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public class NoteBookMapper {
    NoteBookDTO noteBookToNoteBookDto(NoteBookEntity noteBook);

    List<NoteBookDTO> noteBooksToNoteBooksDto(List<NoteBookEntity> noteBooks);

    NoteBookEntity noteBookDtoToNoteBook(NoteBookDTO noteBook);

    List<NoteBookEntity> noteBooksDtoToNoteBooks(List<NoteBookDTO> noteBooks);
}
