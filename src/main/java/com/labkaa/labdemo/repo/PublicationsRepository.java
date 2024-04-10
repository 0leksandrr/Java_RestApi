package com.labkaa.labdemo.repo;

import com.labkaa.labdemo.model.Publications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublicationsRepository extends JpaRepository<Publications, Integer> {

    @Query("SELECT p FROM Publications p WHERE p.author = :author")
    List<Publications> findByAuthor(@Param("author") String author);
    
    @Query("SELECT p FROM Publications p WHERE p.publisher = :publisher")
    List<Publications> findByPublisher(@Param("publisher") String publisher);

}
