package com.github.apz.sample.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
public class Items {
    private List<Item> values;

    public Items() {
        values = new ArrayList<>();
    }

    public Items addItem(Item item) {
        values.add(item);
        return this;
    }

    public Optional<Item> getItem(Integer id) {
        return values.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst();
    }

}
