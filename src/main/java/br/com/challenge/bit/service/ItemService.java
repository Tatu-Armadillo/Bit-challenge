package br.com.challenge.bit.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.challenge.bit.model.Item;
import br.com.challenge.bit.repository.ItemRepository;

@Service
public class ItemService {
    
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private DimensionService dimensionService;

    public List<Item> findAllByDates(LocalDate begindate, LocalDate finaldate) {

        LocalDateTime begindateDb = LocalDateTime.of(begindate, LocalTime.of(0, 0, 0));
        LocalDateTime finaldateDb = LocalDateTime.of(finaldate, LocalTime.of(0, 0, 0));
        
        var itens = this.itemRepository.findByDate(begindateDb, finaldateDb);
        return itens;
    }

    public Item create(Item item) {
        var dimension = this.dimensionService.create(item.getDimension());
        item.setDimension(dimension);
        var response = this.itemRepository.save(item);
        return response;
    }

}
