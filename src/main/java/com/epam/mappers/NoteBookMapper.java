package com.epam.mappers;

import com.epam.dto.NoteBookDto;
import com.epam.entity.NoteBookEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NoteBookMapper {
    NoteBookDto noteBookToNoteBookDto(NoteBookEntity noteBook);

    List<NoteBookDto> noteBooksToNoteBooksDto(List<NoteBookEntity> noteBooks);

    NoteBookEntity noteBookDtoToNoteBook(NoteBookDto noteBook);

    List<NoteBookEntity> noteBooksDtoToNoteBooks(List<NoteBookDto> noteBooks);
}
