package com.epam.controllers.ControllerModels;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class NoteModel {
    private long id;

    private String title;

    private String description;

    private String createDate;

    private Long noteBookId;
}
