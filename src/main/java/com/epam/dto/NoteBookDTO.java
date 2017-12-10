package com.epam.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
import java.util.Set;

@Getter
@Setter
@ToString(exclude = {"notes", "user"})
@EqualsAndHashCode(exclude = {"notes", "user"})
public class NoteBookDTO {
    private long id;

    private String name;

    private Date createDate;

    private UserDTO user;

    private Set<NoteDTO> notes;
}
