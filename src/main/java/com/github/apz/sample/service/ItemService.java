package com.github.apz.sample.service;

import com.github.apz.sample.model.Items;
import com.github.apz.sample.repository.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ItemService {
    ItemRepository itemRepository;

    public Items getItems() {
        return itemRepository.getItems();
    }
}
