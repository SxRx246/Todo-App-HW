package com.ga.items.controller;

import com.ga.items.model.Item;
import com.ga.items.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class ItemController {
    private ItemService itemService;

    @PostMapping("/categories/{categoryId}/items")
    public Item createItem(@PathVariable(name = "categoryId") Long categoryId, @RequestBody Item item){
        System.out.println("Calling createItem() ==>");
        return itemService.createItem(categoryId, item);
    }

    @GetMapping("/categories/{categoryId}/items")
    public List<Item> getItems(@PathVariable(name = "categoryId") Long categoryId){
        System.out.println("Controller calling getItems() ==>");
        return itemService.getItems(categoryId);
    }

    @GetMapping("/categories/{categoryId}/items/{itemId}")
    public Item getItem(@PathVariable(name = "itemId") Long itemId){
        System.out.println("Controller Calling getItem() ==>");
        return itemService.getItem(itemId);
    }

    @PutMapping("/categories/{categoryId}/items/{itemId}")
    public Item updateItem(@PathVariable(name = "itemId") Long itemId, @RequestBody Item item){
        System.out.println("Controller calling updateItem() ==>");
        return itemService.updateItem(itemId,item);
    }

    @DeleteMapping("/categories/{categoryId}/items/{itemId}")
    public void deleteItem(@PathVariable(name = "itemId") Long itemId){
        System.out.println("Controller Calling deleteItem");
        itemService.deleteItem(itemId);
    }
}
