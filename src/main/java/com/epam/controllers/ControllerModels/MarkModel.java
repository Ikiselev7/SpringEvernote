package com.epam.controllers.ControllerModels;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class MarkModel {
    private long id;

    private String name;
}
