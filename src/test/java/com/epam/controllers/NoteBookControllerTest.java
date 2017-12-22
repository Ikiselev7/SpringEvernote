package com.epam.controllers;

import com.epam.controllers.controllerMap.NoteBookTransformer;
import com.epam.models.NoteBookDto;
import com.epam.services.NoteBookService;
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
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class NoteBookControllerTest {
    private ObjectMapper mapper = new ObjectMapper();

    private MockMvc mockMvc;

    private NoteBookDto notebookDto;

    @Mock
    private NoteBookTransformer notebookTransformer;

    private static final Long SIMPLE_NOTEBOOK_ID = 1L;

    @Mock
    private NoteBookService notebookService;

    @InjectMocks
    private NoteBookController notebookController;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.standaloneSetup(notebookController).build();
        notebookDto = new NoteBookDto();
        notebookDto.setId(SIMPLE_NOTEBOOK_ID);
        notebookDto.setName("Notebook");
    }

    @Test
    public void saveNoteBook() throws Exception {
        notebookDto.setId(SIMPLE_NOTEBOOK_ID);
        when(notebookService.save(any(NoteBookDto.class))).thenReturn(notebookDto);

        mockMvc.perform(post("/notebook")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(notebookDto)))
                .andExpect(status().isCreated());

        verify(notebookService).save(any(NoteBookDto.class));
    }

    @Test
    public void getNotebookById() throws Exception {
        when(notebookService.read(anyLong())).thenReturn(notebookDto);

        mockMvc.perform(get("/notebook/" + SIMPLE_NOTEBOOK_ID))
                .andExpect(status().isOk());

        verify(notebookService).read(eq(SIMPLE_NOTEBOOK_ID));
    }

    @Test
    public void getNotesbooksByUser() throws Exception {

    }

    @Test
    public void updateNoteBook() throws Exception {
    }

    @Test
    public void deleteNoteBookById() throws Exception {
        when(notebookService.read(SIMPLE_NOTEBOOK_ID)).thenReturn(notebookDto);
        doNothing().when(notebookService).delete(notebookDto);

        mockMvc.perform(delete("/notebook/" + SIMPLE_NOTEBOOK_ID))
                .andExpect(status().isOk());

        verify(notebookService).delete(any(NoteBookDto.class));
    }

}