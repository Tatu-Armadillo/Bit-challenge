package br.com.challenge.bit.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.challenge.bit.model.Item;
import br.com.challenge.bit.service.ItemService;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    public ResponseEntity<List<Item>> findAllByDates(
            @RequestParam(required = true) @DateTimeFormat(pattern="dd-MM-yyyy") LocalDate begindate,
            @RequestParam(required = true) @DateTimeFormat(pattern="dd-MM-yyyy") LocalDate finaldate) {

        var response = this.itemService.findAllByDates(begindate, finaldate);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Item> create(@RequestBody @Valid Item item) {
        var response = this.itemService.create(item);
        return ResponseEntity.ok(response);
    }

}
