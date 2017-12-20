package com.epam.controllers.ControllerModels;

import com.epam.models.MarkDto;
import com.epam.models.NoteBookDto;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.ZonedDateTime;
import java.util.Set;

@Getter
@Setter
@ToString(exclude = {"marks", "noteBook"})
@EqualsAndHashCode(exclude = {"marks", "noteBook"})
public class NoteModel {
    private long id;

    private String title;

    private String description;

    private ZonedDateTime createDate;

    private Set<MarkDto> marks;

    private NoteBookDto noteBook;
}