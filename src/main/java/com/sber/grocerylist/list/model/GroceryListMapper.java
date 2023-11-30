package com.sber.grocerylist.list.model;

import com.sber.grocerylist.item.model.GroceryItem;
import com.sber.grocerylist.list.dto.GroceryListDto;
import com.sber.grocerylist.author.model.Author;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.HashSet;
import java.util.List;

@Mapper(componentModel = "spring", imports = HashSet.class)
public abstract class GroceryListMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "items", expression = "java(new HashSet<>(groceryItems))")
    public abstract GroceryList toGroceryList(Author author, List<GroceryItem> groceryItems);

    public GroceryListDto toGroceryListDto(GroceryList groceryList) {
        List<String> items = groceryList.getItems().stream().map(GroceryItem::getName).toList();
        GroceryListDto.GroceryListDtoBuilder<?, ?> groceryListDto = GroceryListDto.builder();

        groceryListDto.id(groceryList.getId());
        groceryListDto.items(items);
        return groceryListDto.build();
    }

    public abstract List<GroceryListDto> toGroceryListDto(List<GroceryList> groceryLists);
}
