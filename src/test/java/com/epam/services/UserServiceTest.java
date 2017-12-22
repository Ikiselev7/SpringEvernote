package com.epam.services;

import com.epam.dao.entity.User;
import com.epam.dao.jparepositories.UserJpaRepository;
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
    private User mokedUser;

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserJpaRepository userJpaRepository;

    @Test
    public void save() throws Exception {
        userService.save(mokedUser);
        verify(userJpaRepository).save(mokedUser);
    }

    @Test
    public void update() throws Exception {
        userService.update(mokedUser);
        verify(userJpaRepository).save(mokedUser);
    }

    @Test
    public void read() throws Exception {
        userService.read(23L);
        verify(userJpaRepository).findById(23L);
    }

    @Test
    public void delete() throws Exception {
        userService.delete(mokedUser);
        verify(userJpaRepository).delete(mokedUser);
    }

    @Test
    public void getAll() throws Exception {
        userService.getAll();
        verify(userJpaRepository).findAll();
    }
}