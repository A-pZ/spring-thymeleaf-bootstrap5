package com.github.apz.sample.repository;

import com.github.apz.sample.model.Item;
import com.github.apz.sample.model.Items;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Predicate;

@Repository
@Slf4j
public class ItemRepository {

    Items items;

    @PostConstruct
    public void initialize() {
        items = createItems();
    }

    public Page<Item> getPageItems(Pageable pageable) {
        int pageNumber = pageable.getPageNumber();
        int pageSize = pageable.getPageSize();
        Predicate<Item> pagedStart = item -> item.getId()-1 >= pageNumber * pageSize;
        Predicate<Item> pagedEnd = item -> item.getId() <= (pageNumber + 1) * pageSize;

        List<Item> values = items.getValues();
        List<Item> paged = values.stream().filter(pagedStart.and(pagedEnd)).toList();

        return new PageImpl<>(paged, pageable, values.size());
    }

    Items createItems() {
        items = new Items();
        items.addItem(Item.of(1, "apple", new BigDecimal("100"), 10))
                .addItem(Item.of(2, "banana", new BigDecimal("250"), 20))
                // ここから下はCopilot君が作ってくれたので、適当なデータです
                .addItem(Item.of(3, "cherry", new BigDecimal("100"), 5))
                .addItem(Item.of(4, "dragon fruit", new BigDecimal("300"), 2))
                .addItem(Item.of(5, "egg", new BigDecimal("100"), 50))
                .addItem(Item.of(6, "fig", new BigDecimal("200"), 30))
                .addItem(Item.of(7, "grape", new BigDecimal("150"), 40))
                .addItem(Item.of(8, "honey", new BigDecimal("500"), 10))
                .addItem(Item.of(9, "ice cream", new BigDecimal("200"), 20))
                .addItem(Item.of(10, "jam", new BigDecimal("300"), 10))
                .addItem(Item.of(11, "kiwi", new BigDecimal("100"), 10))
                .addItem(Item.of(12, "lemon", new BigDecimal("150"), 10))
                .addItem(Item.of(13, "mango", new BigDecimal("200"), 10))
                .addItem(Item.of(14, "nut", new BigDecimal("250"), 10))
                .addItem(Item.of(15, "orange", new BigDecimal("100"), 10))
                .addItem(Item.of(16, "pear", new BigDecimal("150"), 10))
                .addItem(Item.of(17, "quince", new BigDecimal("200"), 10))
                .addItem(Item.of(18, "raspberry", new BigDecimal("250"), 10))
                .addItem(Item.of(19, "strawberry", new BigDecimal("100"), 10))
                .addItem(Item.of(20, "tomato", new BigDecimal("150"), 10))
                .addItem(Item.of(21, "umbrella", new BigDecimal("500"), 10))
                .addItem(Item.of(22, "vanilla", new BigDecimal("200"), 10))
                .addItem(Item.of(23, "watermelon", new BigDecimal("300"), 10))
                .addItem(Item.of(24, "xigua", new BigDecimal("250"), 10))
                .addItem(Item.of(25, "yam", new BigDecimal("100"), 10))
                .addItem(Item.of(26, "zucchini", new BigDecimal("150"), 10))
        ;
        return items
        ;
    }

}
