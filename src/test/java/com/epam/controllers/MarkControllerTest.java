package com.epam.controllers;

import com.epam.controllers.controllerMap.MarkTransformer;
import com.epam.dao.entity.Mark;
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
public class MarkControllerTest {
    private static final Long SIMPLE_MARK_ID = 1L;
    private ObjectMapper mapper = new ObjectMapper();
    private MockMvc mockMvc;
    private Mark mark;
    @Mock
    private MarkTransformer userTransformer;
    @Mock
    private MarkService markService;

    @InjectMocks
    private MarkController markController;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.standaloneSetup(markController).build();
        mark = new Mark();
        mark.setId(SIMPLE_MARK_ID);
        mark.setName("Mark");
    }

    @Test
    public void saveMark() throws Exception {
        mark.setId(SIMPLE_MARK_ID);
        when(markService.save(any(Mark.class))).thenReturn(mark);

        mockMvc.perform(post("/mark")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(mark)))
                .andExpect(status().isCreated());

        verify(markService).save(any(Mark.class));
    }

    @Test
    public void getMarkById() throws Exception {
        when(markService.read(anyLong())).thenReturn(Optional.of(mark));

        mockMvc.perform(get("/mark/" + SIMPLE_MARK_ID))
                .andExpect(status().isOk());

        verify(markService).read(eq(SIMPLE_MARK_ID));
    }

    @Test
    public void deleteMarkById() throws Exception {
        when(markService.read(SIMPLE_MARK_ID)).thenReturn(Optional.of(mark));
        doNothing().when(markService).delete(mark);

        mockMvc.perform(delete("/mark/" + SIMPLE_MARK_ID))
                .andExpect(status().isOk());

        verify(markService).delete(any(Mark.class));
    }

}