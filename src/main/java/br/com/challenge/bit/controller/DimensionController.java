package br.com.challenge.bit.controller;

import java.time.LocalDate;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.challenge.bit.model.Dimension;
import br.com.challenge.bit.service.DimensionService;

@RestController
@RequestMapping("/dimension")
public class DimensionController {
    
    @Autowired
    private DimensionService dimensionService;

    @GetMapping
    public ResponseEntity<Page<Dimension>> findAll(
        @PageableDefault(sort = "idDimension", direction = Direction.ASC) Pageable pageable, 
        @RequestParam(required = false) LocalDate begindate, 
        @RequestParam(required = false) LocalDate finaldate) {
        var response =  this.dimensionService.findAll(pageable, begindate, finaldate);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Dimension> create(@RequestBody @Valid Dimension dimension) {
        var response = this.dimensionService.create(dimension);
        return ResponseEntity.ok(response);
    }


}
