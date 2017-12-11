package com.epam.dao.jparepositories;

import com.epam.dao.entity.Mark;
import com.epam.dao.entity.NoteBook;
import com.epam.dao.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteJpaRepository extends JpaRepository<Note, Long>{

    List<Note> findAllByNoteBook(NoteBook noteBook);

    @Query("select n from Note n join n.marks m where m = :mark")
    List<Note> findAllByMark(@Param("mark") Mark mark);
}
