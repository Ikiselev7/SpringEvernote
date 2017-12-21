package com.epam.dao.mappers;

import com.epam.models.NoteBookDto;
import com.epam.dao.entity.NoteBook;
import org.mapstruct.Mapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper(componentModel = "spring")
@Transactional
public interface NoteBookMapper {
    NoteBookDto noteBookToNoteBookDto(NoteBook noteBook);

    List<NoteBookDto> noteBooksToNoteBooksDto(List<NoteBook> noteBooks);

    NoteBook noteBookDtoToNoteBook(NoteBookDto noteBook);

    List<NoteBook> noteBooksDtoToNoteBooks(List<NoteBookDto> noteBooks);
}
