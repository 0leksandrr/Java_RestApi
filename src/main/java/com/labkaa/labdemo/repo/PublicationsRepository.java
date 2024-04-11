package com.labkaa.labdemo.repo;

import com.labkaa.labdemo.model.Publications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicationsRepository extends JpaRepository<Publications, Integer> {

    @Query("SELECT p FROM Publications p WHERE p.x = :x")
    Publications findByX(@Param("x") double x);

    void deleteByX(double x);
}
