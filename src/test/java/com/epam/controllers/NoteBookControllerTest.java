package com.epam.controllers;

import com.epam.controllers.controllerMap.NoteBookTransformer;
import com.epam.dao.entity.NoteBook;
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

import java.util.Optional;

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
public class NoteBookControllerTest {
    private static final Long SIMPLE_NOTEBOOK_ID = 1L;
    private ObjectMapper mapper = new ObjectMapper();
    private MockMvc mockMvc;
    private NoteBook notebook;
    @Mock
    private NoteBookTransformer notebookTransformer;
    @Mock
    private NoteBookService notebookService;

    @InjectMocks
    private NoteBookController notebookController;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.standaloneSetup(notebookController).build();
        notebook = new NoteBook();
        notebook.setId(SIMPLE_NOTEBOOK_ID);
        notebook.setName("Notebook");
    }

    @Test
    public void saveNoteBook() throws Exception {
        notebook.setId(SIMPLE_NOTEBOOK_ID);
        when(notebookService.save(any(NoteBook.class))).thenReturn(notebook);

        mockMvc.perform(post("/notebook")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(notebook)))
                .andExpect(status().isCreated());

        verify(notebookService).save(any(NoteBook.class));
    }

    @Test
    public void getNotebookById() throws Exception {
        when(notebookService.read(anyLong())).thenReturn(Optional.of(notebook));

        mockMvc.perform(get("/notebook/" + SIMPLE_NOTEBOOK_ID))
                .andExpect(status().isOk());

        verify(notebookService).read(eq(SIMPLE_NOTEBOOK_ID));
    }

    @Test
    public void deleteNoteBookById() throws Exception {
        when(notebookService.read(SIMPLE_NOTEBOOK_ID)).thenReturn(Optional.of(notebook));
        doNothing().when(notebookService).delete(notebook);

        mockMvc.perform(delete("/notebook/" + SIMPLE_NOTEBOOK_ID))
                .andExpect(status().isOk());

        verify(notebookService).delete(any(NoteBook.class));
    }

}