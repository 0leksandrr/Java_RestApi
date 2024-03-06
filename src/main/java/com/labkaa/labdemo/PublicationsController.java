package com.labkaa.labdemo;

import com.labkaa.labdemo.model.Publications;
import com.labkaa.labdemo.repo.PublicationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publications")
public class PublicationsController {

    @Autowired
    private PublicationsRepository publicationsRepository;

    // Операція додавання
    @PostMapping("/add")
    public void addPublication(@RequestBody Publications publication) {
        publicationsRepository.save(publication);
    }

    // Операція перегляду за id
    @GetMapping("/{id}")
    public Publications getPublicationById(@PathVariable int id) {
        return publicationsRepository.findById(id);
    }

    // Операція перегляду повного переліку
    @GetMapping
    public List<Publications> getAllPublications() {
        return publicationsRepository.findAll();
    }

    // Операція видалення за id
    @DeleteMapping("/{id}")
    public void deletePublicationById(@PathVariable int id) {
        publicationsRepository.deleteById(id);
    }

    // Операція видалення повного переліку
    @DeleteMapping
    public void deleteAllPublications() {
        publicationsRepository.deleteAll();
    }

    // Операція модифікації за id
    @PutMapping("/{id}")
    public void updatePublication(@PathVariable int id, @RequestBody Publications publication) {
        publication.setId(id);
        publicationsRepository.saveAndFlush(publication);
    }

    // Операція перегляду за автором
    @GetMapping("/author/{author}")
    public List<Publications> getPublicationsByAuthor(@PathVariable String author) {
        return publicationsRepository.findByAuthor(author);
    }

    // Операція перегляду за видавництвом
    @GetMapping("/publisher/{publisher}")
    public List<Publications> getPublicationsByPublisher(@PathVariable String publisher) {
        return publicationsRepository.findByPublisher(publisher);
    }
}
