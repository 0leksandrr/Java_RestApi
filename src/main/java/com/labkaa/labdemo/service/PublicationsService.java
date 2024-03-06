package com.labkaa.labdemo.service;

import com.labkaa.labdemo.model.Publications;
import com.labkaa.labdemo.repo.PublicationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicationsService {

    @Autowired
    private PublicationsRepository publicationsRepository;

    // Операція додавання
    public void addPublication(Publications publication) {
        publicationsRepository.save(publication);
    }

    // Операція перегляду за id
    public Publications getPublicationById(int id) {
        return publicationsRepository.findById(id);
    }

    // Операція перегляду повного переліку
    public List<Publications> getAllPublications() {
        return publicationsRepository.findAll();
    }

    // Операція видалення за id
    public void deletePublicationById(int id) {
        publicationsRepository.deleteById(id);
    }

    // Операція видалення повного переліку
    public void deleteAllPublications() {
        publicationsRepository.deleteAll();
    }

    // Операція модифікації за id
    public void updatePublication(int id, Publications publication) {
        publication.setId(id);
        publicationsRepository.saveAndFlush(publication);
    }

    // Операція перегляду за автором
    public List<Publications> getPublicationsByAuthor(String author) {
        return publicationsRepository.findByAuthor(author);
    }

    // Операція перегляду за видавництвом
    public List<Publications> getPublicationsByPublisher(String publisher) {
        return publicationsRepository.findByPublisher(publisher);
    }
}
