package com.epam.controllers;

import com.epam.controllers.ControllerModels.MarkModel;
import com.epam.controllers.controllerMap.MarkTransformer;
import com.epam.models.MarkDto;
import com.epam.models.NoteDto;
import com.epam.services.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MarkController {
    //TODO for Maksim
    @Autowired
    MarkTransformer markTransformer;

    @GetMapping(value = "/hello")
    public ResponseEntity<String> getAllByMark() {
        return new ResponseEntity<>("hello", HttpStatus.OK);
    }


}
