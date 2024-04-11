package com.labkaa.labdemo.service;

import com.labkaa.labdemo.model.Publications;
import com.labkaa.labdemo.repo.PublicationsRepository;
import org.apache.commons.math3.stat.regression.SimpleRegression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicationsService {

    @Autowired
    private PublicationsRepository publicationsRepository;

    public void addSequences(List<Publications> sequences) {
        publicationsRepository.deleteAll();
        publicationsRepository.saveAll(sequences);
    }

    public List<Publications> getAllSequences() {
        return publicationsRepository.findAll();
    }

    public double getRegressionValue(double x) {
        List<Publications> publications = publicationsRepository.findAll();

        SimpleRegression regression = new SimpleRegression();
        for (Publications publication : publications) {
            regression.addData(publication.getX(), publication.getY());
        }

        return regression.predict(x);
    }
}
