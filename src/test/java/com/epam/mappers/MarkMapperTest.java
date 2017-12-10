package com.epam.mappers;

import com.epam.dto.MarkDto;
import com.epam.dto.NoteDto;
import com.epam.entity.MarkEntity;
import com.epam.entity.NoteEntity;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class MarkMapperTest {
    @Test
    public void markToMarkDto() throws Exception {
        MarkEntity mark = new MarkEntity();
        mark.setId(123L);
        mark.setName("Mark1");

        NoteEntity noteEntity = new NoteEntity();
        noteEntity.setId(321L);
        Set<NoteEntity> noteEntitySet = new HashSet<>();
        noteEntitySet.add(noteEntity);
        mark.setNotes(noteEntitySet);

        MarkDto markDto1 = new MarkDto();
        NoteDto noteDto = new NoteDto();
        noteDto.setId(321L);
        Set<NoteDto> noteDtoSet = new HashSet<>();
        noteDtoSet.add(noteDto);
        markDto1.setNotes(noteDtoSet);

        MarkDto markDto = MarkMapper.INSTANCE.markToMarkDto(mark);
        assertEquals(markDto.getId(), mark.getId());
        assertEquals(markDto.getName(), mark.getName());
        assertEquals(markDto.getNotes(), markDto1.getNotes());

    }

    @Test
    public void marksDtoToMarks() throws Exception {
        MarkDto markDto = new MarkDto();
        markDto.setId(321L);
        markDto.setName("Mark2");

        MarkDto markDto1 = new MarkDto();
        markDto.setId(321L);
        markDto.setName("Mark2");

        List<MarkEntity> mark = MarkMapper.INSTANCE.marksDtoToMarks(Arrays.asList(markDto, markDto1));

        assertEquals(mark.get(0).getId(), markDto.getId());
        assertEquals(mark.get(0).getName(), markDto.getName());

        assertEquals(mark.get(1).getId(), markDto1.getId());
        assertEquals(mark.get(1).getName(), markDto1.getName());

    }

}