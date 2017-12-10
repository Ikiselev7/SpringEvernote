package com.epam.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
import java.util.Set;

@Getter
@Setter
@ToString(exclude = {"marks", "noteBook"})
@EqualsAndHashCode(exclude = {"marks", "noteBook"})
public class NoteDto {
    private long id;

    private String title;

    private String description;

    private Date createDate;

    private Set<MarkDto> marks;

    private NoteBookDto noteBook;
}
