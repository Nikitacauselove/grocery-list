package com.sber.grocerylist.item.model;

import com.sber.grocerylist.item.dto.GroceryItemDto;
import com.sber.grocerylist.item.dto.GroceryItemShortDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface GroceryItemMapper {
    GroceryItem toGroceryItem(GroceryItemShortDto groceryItemShortDto);

    @Mapping(target = "id", source = "groceryItem.id")
    @Mapping(target = "name", source = "groceryItemShortDto.name")
    GroceryItem toGroceryItem(GroceryItem groceryItem, GroceryItemShortDto groceryItemShortDto);

    GroceryItemDto toGroceryItemDto(GroceryItem groceryItem);

    List<GroceryItemDto> toGroceryItemDto(List<GroceryItem> groceryItems);
}
