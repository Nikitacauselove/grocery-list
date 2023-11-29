package com.sber.grocerylist.item;

import com.sber.grocerylist.item.dto.GroceryItemDto;
import com.sber.grocerylist.item.model.GroceryItemMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "items")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class GroceryItemPublicController {
    private final GroceryItemMapper groceryItemMapper;
    private final GroceryItemService groceryItemService;

    @GetMapping("/{itemId}")
    public GroceryItemDto findById(@PathVariable Long itemId) {
        return groceryItemMapper.toGroceryItemDto(groceryItemService.findById(itemId));
    }

    @GetMapping
    public List<GroceryItemDto> findAll() {
        return groceryItemMapper.toGroceryItemDto(groceryItemService.findAll());
    }
}
