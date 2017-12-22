package com.epam.controllers.ControllerModels;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class NoteBookModel {
    private long id;

    private String name;

    private String createDate;

    private Long userId;
}
