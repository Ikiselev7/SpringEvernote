package com.epam.dao;

import com.epam.entity.NoteBookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteBookDao extends JpaRepository<NoteBookEntity, Long> {
}
