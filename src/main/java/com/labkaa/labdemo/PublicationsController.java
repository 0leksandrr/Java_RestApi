package com.labkaa.labdemo;

import com.labkaa.labdemo.model.Publications;
import com.labkaa.labdemo.service.PublicationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publications")
public class PublicationsController {

    @Autowired
    private PublicationsService publicationsService;

    // Операція додавання
    @PostMapping("/add")
    public Publications addPublication(@RequestBody Publications publication) {
        return publicationsService.addPublication(publication);
    }

    // Операція перегляду за id
    @GetMapping("/{id}")
    public Publications getPublicationById(@PathVariable int id) {
        return publicationsService.getPublicationById(id);
    }

    // Операція перегляду повного переліку
    @GetMapping
    public List<Publications> getAllPublications() {
        return publicationsService.getAllPublications();
    }

    // Операція видалення за id
    @DeleteMapping("/{id}")
    public void deletePublicationById(@PathVariable int id) {
        publicationsService.deletePublicationById(id);
    }

    // Операція модифікації за id
    @PutMapping("/{id}")
    public Publications updatePublication(@PathVariable int id, @RequestBody Publications publication) {
        return publicationsService.updatePublication(id, publication);
    }

    // Операція перегляду за автором
    @GetMapping("/author/{author}")
    public List<Publications> getPublicationsByAuthor(@PathVariable String author) {
        return publicationsService.getPublicationsByAuthor(author);
    }

    // Операція перегляду за видавництвом
    @GetMapping("/publisher/{publisher}")
    public List<Publications> getPublicationsByPublisher(@PathVariable String publisher) {
        return publicationsService.getPublicationsByPublisher(publisher);
    }
}
