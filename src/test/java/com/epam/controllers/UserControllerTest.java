package com.epam.controllers;

import com.epam.controllers.controllerMap.UserTransformer;
import com.epam.dao.entity.User;
import com.epam.services.UserService;
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
public class UserControllerTest {
    private static final Long SIMPLE_USER_ID = 1L;
    private ObjectMapper mapper = new ObjectMapper();
    private MockMvc mockMvc;
    private User userDto;
    @Mock
    private UserTransformer userTransformer;
    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
        userDto = new User();
        userDto.setId(SIMPLE_USER_ID);
        userDto.setFirstName("Ivan");
        userDto.setLastName("Ivanov");
        userDto.setEmail("ivanov@gmail.com");
    }

    @Test
    public void saveUser() throws Exception {
        userDto.setId(SIMPLE_USER_ID);
        when(userService.save(any(User.class))).thenReturn(userDto);

        mockMvc.perform(post("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(userDto)))
                .andExpect(status().isCreated());

        verify(userService).save(any(User.class));
    }

    @Test
    public void getUserById() throws Exception {
        when(userService.read(anyLong())).thenReturn(Optional.of(userDto));

        mockMvc.perform(get("/user/" + SIMPLE_USER_ID))
                .andExpect(status().isOk());

        verify(userService).read(eq(SIMPLE_USER_ID));
    }

    @Test
    public void deleteUserById() throws Exception {
        when(userService.read(SIMPLE_USER_ID)).thenReturn(Optional.of(userDto));
        doNothing().when(userService).delete(userDto);

        mockMvc.perform(delete("/user/" + SIMPLE_USER_ID))
                .andExpect(status().isOk());

        verify(userService).delete(any(User.class));
    }

}