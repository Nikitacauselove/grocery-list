package com.sber.grocerylist.item.model;

import com.sber.grocerylist.item.dto.GroceryItemDto;
import com.sber.grocerylist.item.dto.GroceryItemShortDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GroceryItemMapper {
    GroceryItem toGroceryItem(GroceryItemShortDto groceryItemShortDto);

    GroceryItemDto toGroceryItemDto(GroceryItem groceryItem);

    List<GroceryItemDto> toGroceryItemDto(List<GroceryItem> groceryItems);
}
