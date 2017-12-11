package com.epam.dao.jparepositories;

import com.epam.dao.entity.NoteBook;
import com.epam.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteBookJpaRepository extends JpaRepository<NoteBook, Long> {

    List<NoteBook> findAllByUser(User user);
}
