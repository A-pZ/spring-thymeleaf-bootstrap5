package com.github.apz.sample.controller;

import com.github.apz.sample.model.Item;
import com.github.apz.sample.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
@AllArgsConstructor
public class ItemController {

    ItemService itemService;

    @GetMapping("/")
    public ModelAndView index(ModelAndView mnv) {
        mnv.setViewName("index");
        return mnv;
    }

    @GetMapping("/list")
    public ModelAndView list(ModelAndView mnv, Pageable pageable) {
        Page<Item> pageItems = itemService.getPageItems(pageable);
        mnv.addObject("pages", pageItems);
        mnv.setViewName("list");
        return mnv;
    }

    @GetMapping("/item/{itemId}")
    public ModelAndView getItem(ModelAndView mnv, @PathVariable("itemId") Integer itemId) {
        Item item = itemService.getItem(itemId);
        mnv.addObject("item", item);
        mnv.setViewName("item");
        return mnv;
    }

}
