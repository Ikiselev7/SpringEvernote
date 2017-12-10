package com.epam.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@ToString(exclude = {"notes"})
@EqualsAndHashCode(exclude = {"notes"})
public class MarkDTO {
    private long id;

    private String name;

    private Set<NoteDTO> notes;
}
