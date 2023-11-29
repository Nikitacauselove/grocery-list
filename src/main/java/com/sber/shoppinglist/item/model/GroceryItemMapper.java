package com.sber.shoppinglist.item.model;

import com.sber.shoppinglist.item.dto.GroceryItemDto;
import com.sber.shoppinglist.item.dto.GroceryItemShortDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GroceryItemMapper {
    GroceryItem toGroceryItem(GroceryItemShortDto groceryItemShortDto);

    @Mapping(target = "id", source = "groceryItem.id")
    @Mapping(target = "name", source = "groceryItemShortDto.name")
    GroceryItem toGroceryItem(GroceryItem groceryItem, GroceryItemShortDto groceryItemShortDto);

    GroceryItemDto toGroceryItemDto(GroceryItem groceryItem);

    List<GroceryItemDto> toGroceryItemDto(List<GroceryItem> groceryItems);
}
