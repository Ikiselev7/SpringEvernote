package com.epam.controllers;

import com.epam.controllers.controllerMap.MarkTransformer;
import com.epam.models.MarkDto;
import com.epam.models.NoteBookDto;
import com.epam.services.MarkService;
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
public class MarkControllerTest {
    private ObjectMapper mapper = new ObjectMapper();

    private MockMvc mockMvc;

    private MarkDto markDto;

    @Mock
    private MarkTransformer userTransformer;

    private static final Long SIMPLE_MARK_ID = 1L;

    @Mock
    private MarkService markService;

    @InjectMocks
    private MarkController markController;

    @Test
    public void saveMark() throws Exception {
        markDto.setId(SIMPLE_MARK_ID);
        when(markService.save(any(MarkDto.class))).thenReturn(markDto);

        mockMvc.perform(post("/mark")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(markDto)))
                .andExpect(status().isCreated());

        verify(markService).save(any(MarkDto.class));
    }

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.standaloneSetup(markController).build();
        markDto = new MarkDto();
        markDto.setId(SIMPLE_MARK_ID);
        markDto.setName("Mark");
    }

    @Test
    public void getMarkById() throws Exception {
        when(markService.read(anyLong())).thenReturn(markDto);

        mockMvc.perform(get("/mark/" + SIMPLE_MARK_ID))
                .andExpect(status().isOk());

        verify(markService).read(eq(SIMPLE_MARK_ID));
    }

    @Test
    public void getMarksByUser() throws Exception {
    }

    @Test
    public void getMarksByNote() throws Exception {
    }

    @Test
    public void updateMark() throws Exception {
    }

    @Test
    public void deleteMarkById() throws Exception {
        when(markService.read(SIMPLE_MARK_ID)).thenReturn(markDto);
        doNothing().when(markService).delete(markDto);

        mockMvc.perform(delete("/mark/" + SIMPLE_MARK_ID))
                .andExpect(status().isOk());

        verify(markService).delete(any(MarkDto.class));
    }

}