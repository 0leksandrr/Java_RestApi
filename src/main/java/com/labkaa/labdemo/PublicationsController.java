package com.labkaa.labdemo;

import com.labkaa.labdemo.model.Publications;
import com.labkaa.labdemo.service.PublicationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PublicationsController {

    @Autowired
    private PublicationsService publicationsService;

    @PostMapping("/sequences")
    public void addSequences(@RequestBody List<Publications> sequences) {
        publicationsService.addSequences(sequences);
    }

    @GetMapping("/sequences")
    public List<Publications> getAllSequences() {
        return publicationsService.getAllSequences();
    }

    @GetMapping("/regression/{x}")
    public double getRegressionValue(@PathVariable double x) {
        // Отримати прогнозоване значення y
        return publicationsService.getRegressionValue(x);
    }
}

