package br.com.challenge.bit.service;

import java.util.Date;
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

    public List<Item> findAll() {
        return this.itemRepository.findAll();
    }

    public List<Item> findAllByDates(Date begindate, Date finaldate) {
        var itens = this.itemRepository.findByDate(begindate, finaldate);
        return itens;
    }

    public Item create(Item item) {
        var dimension = this.dimensionService.create(item.getDimension());
        item.setDimension(dimension);
        var response = this.itemRepository.save(item);
        return response;
    }

    public List<Item> createByList(List<Item> itens) {
        itens.forEach(item -> this.create(item));
        var response = this.findAll();
        return response;
    }

}
