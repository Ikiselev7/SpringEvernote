package com.epam.services;

import com.epam.dao.dto.impl.UserDaoDtoImpl;
import com.epam.dto.UserDto;
import com.epam.services.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    @Mock
    private UserDto mokedUser;

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserDaoDtoImpl userDaoDto;

    @Test
    public void save() throws Exception {
        userService.save(mokedUser);
        verify(userDaoDto).save(mokedUser);
    }

    @Test
    public void update() throws Exception {
        userService.update(mokedUser);
        verify(userDaoDto).save(mokedUser);
    }

    @Test
    public void read() throws Exception {
        userService.read(23L);
        verify(userDaoDto).findById(23L);
    }

    @Test
    public void delete() throws Exception {
        userService.delete(mokedUser);
        verify(userDaoDto).delete(mokedUser);
    }

    @Test
    public void getAll() throws Exception {
        userService.getAll();
        verify(userDaoDto).findAll();
    }
}