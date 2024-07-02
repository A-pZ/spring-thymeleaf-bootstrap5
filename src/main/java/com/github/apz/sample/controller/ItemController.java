package com.github.apz.sample.controller;

import com.github.apz.sample.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
    public ModelAndView list(ModelAndView mnv) {
        var items = itemService.getItems();
        mnv.addObject("items", items.getValues());
        mnv.setViewName("list");
        return mnv;
    }
}
