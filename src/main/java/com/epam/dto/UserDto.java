package com.epam.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@ToString(exclude = {"noteBooks"})
@EqualsAndHashCode(exclude = {"noteBooks"})
public class UserDto {
    private long id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private Set<NoteBookDto> noteBooks;
}
