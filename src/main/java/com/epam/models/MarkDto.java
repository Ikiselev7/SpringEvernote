package com.epam.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@ToString(exclude = {"notes"})
@EqualsAndHashCode(exclude = {"notes"})
public class MarkDto {
    private long id;

    private String name;

    private Set<NoteDto> notes;
}
