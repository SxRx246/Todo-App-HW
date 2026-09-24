package com.ga.items.service;

import com.ga.items.acception.InformationNotFoundException;
import com.ga.items.model.Category;
import com.ga.items.model.Item;
import com.ga.items.repository.CategoryRepository;
import com.ga.items.repository.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ItemService {
    private ItemRepository itemRepository;

    private CategoryRepository categoryRepository;

    public Item createItem(Long categoryId, Item item){
        System.out.println("calling createItem");
        Category category = categoryRepository.findById(categoryId)
                        .orElseThrow(() ->
                                new InformationNotFoundException(
                                        "category with id " + categoryId + " is not found"
                                ));

        item.setCategory(category);

        return itemRepository.save(item);
    }

    public List<Item> getItems(Long categoryId){
        System.out.println("Service Calling getItems() ==>");
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() ->
                        new InformationNotFoundException(
                                "category with id " + categoryId + " is not found"
                        ));
        return itemRepository.findByCategoryId(categoryId);
    }

    public Item getItem(Long itemId){
        System.out.println("Service Calling getItem() ==>");
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() ->
                        new InformationNotFoundException(
                                "item with id " + itemId + " is not found"
                        ));
        return item;
    }

    public Item updateItem(Long itemId, Item item){
        System.out.println("Service Calling updateItem() ==>");
        Item existingItem = itemRepository.findById(itemId)
                .orElseThrow(() ->
                        new InformationNotFoundException(
                                "item with id "+ itemId + " is not found"
                        ));
        existingItem.setName(item.getName());
        existingItem.setDescription(item.getDescription());
        existingItem.setDueDate(item.getDueDate());

        return itemRepository.save(existingItem);
    }

    public void deleteItem(Long itemId){
        System.out.println("Service calling deleteItem() ->");
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() ->
                        new InformationNotFoundException(
                                "item with id " + itemId + " is not found"
                        ));
        itemRepository.deleteById(itemId);
    }
}
