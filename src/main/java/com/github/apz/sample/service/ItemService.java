package com.github.apz.sample.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.github.apz.sample.model.Item;
import com.github.apz.sample.repository.ItemRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ItemService {
    ItemRepository itemRepository;

    public Page<Item> getPageItems(Pageable pageable) {
        return itemRepository.getPageItems(pageable);
    }

    public Item getItem(Integer id) {
        return itemRepository.getItem(id);
    }
    
    public List<Item> getAllItems() {
    	return itemRepository.getAll();
    }
}
