package com.epam.controllers.ControllerModels;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.ZonedDateTime;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class NoteBookModel {
    private long id;

    private String name;

    private ZonedDateTime createDate;

    private Long userId;
}
