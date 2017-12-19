package com.epam.controllers;

import com.epam.models.MarkDto;
import com.epam.models.NoteDto;
import com.epam.models.UserDto;
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

    @GetMapping(value = "user/{id}/marks")
    public ResponseEntity<List<MarkDto>> getAllByMark(@PathVariable("userDto") UserDto user) {
        return new ResponseEntity<>(markService.getByMark(user), HttpStatus.OK);
    }

    @GetMapping(value = "user/{id}/marks")
    public ResponseEntity<List<MarkDto>> getAllByNote(@PathVariable("noteDto")NoteDto noteDto) {
        return new ResponseEntity<>(markService.getAllByNote(noteDto), HttpStatus.OK);
    }

    @PostMapping(value = "user/{id}/notebook/{id}/note/{id}/mark")
    public ResponseEntity<MarkDto> saveMark(@PathVariable("markDto") MarkDto markDto) {
        return new ResponseEntity<>(markService.save(markDto), HttpStatus.OK);
    }

    @PutMapping(value = "user/{id}/notebook/{id}/note/{id}/mark")
    public ResponseEntity<MarkDto> updateMark(@PathVariable("markDto") MarkDto markDto) {
        return new ResponseEntity<>(markService.update(markDto), HttpStatus.OK);
    }

    @GetMapping(value = "user/{id}/mark/{id}")
    public ResponseEntity<MarkDto> getMarkById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(markService.read(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "user/{id}/notebook/{id}/note/{id}/mark")
    public void deleteMarkById(@PathVariable("markDto") MarkDto markDto) {
        markService.delete(markDto);
    }

}
