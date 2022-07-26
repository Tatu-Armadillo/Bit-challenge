package br.com.challenge.bit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.challenge.bit.model.Dimension;

@Repository
public interface DimensionRepository extends JpaRepository<Dimension, Long>{
    
}
