package com.github.apz.sample.repository;

import com.github.apz.sample.MiscProperties;
import com.github.apz.sample.model.Item;
import com.github.apz.sample.model.Items;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
@Slf4j
public class ItemRepository {

    MiscProperties miscProperties;
    Items items;

    public ItemRepository(MiscProperties miscProperties) {
        this.miscProperties = miscProperties;
    }

    @PostConstruct
    public void initialize() {
        items = new Items();
        items.addItem(Item.of(1, "apple", new BigDecimal("100"), 10))
            .addItem(Item.of(2, "banana", new BigDecimal("250"), 20))
            .addItem(Item.of(3, "cherry", new BigDecimal("100"), 5))
            .addItem(Item.of(4, "dragon fruit", new BigDecimal("300"), 2))
            .addItem(Item.of(5, "egg", new BigDecimal("100"), 50))
        ;
    }

    public Items getItems() {
        try {
            Thread.sleep(miscProperties.getWaitMilliSeconds());
        } catch (InterruptedException e) {
            log.error("sleep error", e);
        }
        return items;
    }

    public Optional<Item> getItem(Integer id) {
        return items.getItem(id);
    }

    public void addItem(Item item) {
        items.addItem(item);
    }
}
