package com.github.apz.sample.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor(staticName = "of") @Getter @Setter
public class Item {
    private Integer id;
    private String name;
    private BigDecimal price;
    private Integer stock;
}
