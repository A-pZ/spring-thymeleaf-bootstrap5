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

import java.util.List;

@Controller
@RequestMapping("/infinite")
@AllArgsConstructor
public class InfiniteItemController {
    ItemService itemService;

    @GetMapping("/")
    public ModelAndView index(ModelAndView mnv) {
        mnv.setViewName("infinite-index");
        return mnv;
    }

    @GetMapping("/list")
    public ModelAndView list(ModelAndView mnv, Pageable pageable) {
        Page<Item> pageItems = itemService.getPageItems(pageable);
        mnv.addObject("pages", pageItems);
        mnv.setViewName("infinite-list");
        return mnv;
    }

}
