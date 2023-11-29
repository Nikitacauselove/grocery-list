package com.sber.shoppinglist.item;

import com.sber.shoppinglist.item.dto.GroceryItemDto;
import com.sber.shoppinglist.item.dto.GroceryItemShortDto;
import com.sber.shoppinglist.item.model.GroceryItem;
import com.sber.shoppinglist.item.model.GroceryItemMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "admin/items")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class GroceryItemAdminController {
    private final GroceryItemMapper groceryItemMapper;
    private final GroceryItemService groceryItemService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GroceryItemDto create(@RequestBody @Valid GroceryItemShortDto groceryItemShortDto) {
        GroceryItem groceryItem = groceryItemMapper.toGroceryItem(groceryItemShortDto);

        return groceryItemMapper.toGroceryItemDto(groceryItemService.create(groceryItem));
    }

    @PutMapping("/{itemId}")
    public GroceryItemDto update(@PathVariable Long itemId, @RequestBody @Valid GroceryItemShortDto groceryItemShortDto) {
        GroceryItem groceryItem = groceryItemMapper.toGroceryItem(groceryItemService.findById(itemId), groceryItemShortDto);

        return groceryItemMapper.toGroceryItemDto(groceryItemService.update(groceryItem));
    }

    @DeleteMapping("/{itemId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long itemId) {
        groceryItemService.deleteById(itemId);
    }
}
