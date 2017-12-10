package com.epam.dao;


import com.epam.entity.MarkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarkDao extends JpaRepository<MarkEntity, Long> {

}
