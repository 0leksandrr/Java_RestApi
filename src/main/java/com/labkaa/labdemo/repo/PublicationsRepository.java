package com.labkaa.labdemo.repo;

import com.labkaa.labdemo.model.Publications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublicationsRepository extends JpaRepository<Publications, Integer> {
    // Операція додавання
    Publications save(Publications publication);

    // Операція перегляду за id
    Publications findById(int id);

    // Операція перегляду повного переліку
    List<Publications> findAll();

    // Операція видалення за id
    void deleteById(int id);

    // Операція видалення повного переліку
    void deleteAll();

    // Операція модифікації за id
    Publications saveAndFlush(Publications publication);

    // Операція перегляду за автором
    List<Publications> findByAuthor(String author);

    // Операція перегляду за видавництвом
    List<Publications> findByPublisher(String publisher);
}
