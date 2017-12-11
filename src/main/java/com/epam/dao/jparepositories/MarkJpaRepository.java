package com.epam.dao.jparepositories;


import com.epam.dao.entity.Mark;
import com.epam.dao.entity.Note;
import com.epam.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarkJpaRepository extends JpaRepository<Mark, Long> {

    @Query("select m from Mark m join m.notes n where n = :note")
    List<Mark> findAllByNote(@Param("note") Note note);

    @Query("select m from Mark m join m.notes n join n.noteBook nb join nb.user u where u = :user")
    List<Mark> findAllByUser(@Param("user") User user);
}
