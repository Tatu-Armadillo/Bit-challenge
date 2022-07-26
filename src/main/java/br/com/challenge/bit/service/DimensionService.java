package br.com.challenge.bit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.challenge.bit.model.Dimension;
import br.com.challenge.bit.repository.DimensionRepository;

@Service
public class DimensionService {
    
    @Autowired
    private DimensionRepository dimensionRepository;

    public Dimension create(Dimension dimension) {
        var response = this.dimensionRepository.save(dimension);
        return response;
    }

    public Page<Dimension> findAll(Pageable pageable) {
        return this.dimensionRepository.findAll(pageable);
    } 

}
