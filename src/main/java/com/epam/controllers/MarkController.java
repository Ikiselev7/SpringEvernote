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

import java.util.List;

public class MarkController {
    //TODO for Maksim

    @Autowired
    MarkService markService;
    @Autowired
    MarkTransformer markTransformer;


    @PostMapping(value = "user/{id}/notebook/{id}/note/{id}/mark")
    public ResponseEntity<MarkDto> saveMark(@PathVariable("markDto") MarkDto markDto) {
        return new ResponseEntity<>(markService.save(markDto), HttpStatus.OK);
    }

    @GetMapping(value = "user/{id}/marks")
    public ResponseEntity<List<MarkDto>> getAllMarkByUser(@PathVariable("id") Long id) {
        return new ResponseEntity<>(markService.getAllMarkByUser(id), HttpStatus.OK);
    }

    @GetMapping(value = "note/{id}/marks")
    public ResponseEntity<List<MarkDto>> getAllByNote(@PathVariable("id") NoteDto noteDto) {
        return new ResponseEntity<>(markService.getAllByNote(noteDto), HttpStatus.OK);
    }

    @PutMapping(value = "mark")
    public ResponseEntity<MarkDto> updateMark(@PathVariable("markDto") MarkDto markDto) {
        return new ResponseEntity<>(markService.update(markDto), HttpStatus.OK);
    }

    @GetMapping(value = "mark/{id}")
    public ResponseEntity<MarkModel> getMarkById(@PathVariable("id") Long id) {
        MarkDto markDto = markService.read(id);

        if(markDto == null) {
            throw new IllegalArgumentException("Bad id " + id);
        }
        MarkModel markModel = markTransformer.unbind(markDto);


        return new ResponseEntity<>(markModel, HttpStatus.OK);
    }

    @DeleteMapping(value = "mark")
    public void deleteMarkById(@PathVariable("markDto") MarkDto markDto) {

        markService.delete(markDto);
    }

}
