package com.github.apz.sample.service;

import com.github.apz.sample.model.Item;
import com.github.apz.sample.repository.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
}
