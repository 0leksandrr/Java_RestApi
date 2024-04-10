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
    public Publications addPublication(Publications publication) {
        return publicationsRepository.save(publication);
    }

    // Операція перегляду за id
    public Publications getPublicationById(int id) {
        return publicationsRepository.findById(id).orElse(null);
    }

    // Операція перегляду повного переліку
    public List<Publications> getAllPublications() {
        return publicationsRepository.findAll();
    }

    // Операція видалення за id
    public void deletePublicationById(int id) {
        publicationsRepository.deleteById(id);
    }

    // Операція модифікації за id
    public Publications updatePublication(int id, Publications publication) {
        if (publicationsRepository.existsById(id)) {
            publication.setId(id);
            return publicationsRepository.saveAndFlush(publication);
        } else {
            return null;
        }
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
