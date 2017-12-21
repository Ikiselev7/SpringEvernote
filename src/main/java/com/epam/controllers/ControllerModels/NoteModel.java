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
@ToString
@EqualsAndHashCode
public class NoteModel {
    private long id;

    private String title;

    private String description;

    private String createDate;

    private Long noteBookId;
}
