package com.epam.controllers.controllerMap;

import com.epam.controllers.ControllerModels.MarkModel;
import com.epam.controllers.mappers.MarkMapper;
import com.epam.controllers.mappers.NoteMapper;
import com.epam.controllers.mappers.UserMapper;
import com.epam.dao.entity.Note;
import com.epam.dao.entity.User;
import com.epam.models.MarkDto;
import com.epam.models.NoteDto;
import com.epam.models.UserDto;
import com.epam.services.MarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MarkControllerMap {
    @Autowired
    private MarkService markService;

    private final MarkMapper markMapper;

    private final NoteMapper noteMapper;

    private final UserMapper userMapper;

    public MarkModel save(MarkModel markModel) {
        return markMapper.markDtoToMarkModel(markService.
                save(markMapper.markModelToMarkDto(markModel)));
    }



    @Override
    public MarkDto findById(Long id) {
        return markMapper.markToMarkDto(markJpaRepository.findById(id).get());
    }

    @Override
    public void delete(MarkDto markDto) {
        markJpaRepository.delete(markMapper.markDtoToMark(markDto));
    }

    @Override
    public List<MarkDto> findAllByNote(NoteDto noteDto) {
        Note note = noteMapper.noteDtoToNote(noteDto);
        return markMapper.marksToMarksDto(markJpaRepository.findAllByNote(note));
    }

    @Override
    public List<MarkDto> findAllByUserId(UserDto userDto) {
        User user = userMapper.userDtoToUser(userDto);
        return markMapper.marksToMarksDto(markJpaRepository.findAllByUser(user));
    }
}
