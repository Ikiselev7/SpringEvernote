package com.epam.controllers;

import com.epam.controllers.controllerMap.NoteTransformer;
import com.epam.models.NoteDto;
import com.epam.services.NoteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class NoteControllerTest {
    private ObjectMapper mapper = new ObjectMapper();

    private MockMvc mockMvc;

    private NoteDto noteDto;

    @Mock
    private NoteTransformer noteTransformer;

    private static final Long SIMPLE_NOTE_ID = 1L;

    @Mock
    private NoteService noteService;

    @InjectMocks
    private NoteController noteController;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.standaloneSetup(noteController).build();
        noteDto = new NoteDto();
        noteDto.setId(SIMPLE_NOTE_ID);
        noteDto.setTitle("Note");
        noteDto.setDescription("Note description");
    }

    @Test
    public void saveNote() throws Exception {
        noteDto.setId(SIMPLE_NOTE_ID);
        when(noteService.save(any(NoteDto.class))).thenReturn(noteDto);

        mockMvc.perform(post("/note")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(noteDto)))
                .andExpect(status().isCreated());

        verify(noteService).save(any(NoteDto.class));
    }

    @Test
    public void getNoteById() throws Exception {
        when(noteService.read(anyLong())).thenReturn(noteDto);

        mockMvc.perform(get("/note/" + SIMPLE_NOTE_ID))
                .andExpect(status().isOk());

        verify(noteService).read(eq(SIMPLE_NOTE_ID));
    }

    @Test
    public void deleteNoteById() throws Exception {
        when(noteService.read(SIMPLE_NOTE_ID)).thenReturn(noteDto);
        doNothing().when(noteService).delete(noteDto);

        mockMvc.perform(delete("/note/" + SIMPLE_NOTE_ID))
                .andExpect(status().isOk());

        verify(noteService).delete(any(NoteDto.class));
    }

}