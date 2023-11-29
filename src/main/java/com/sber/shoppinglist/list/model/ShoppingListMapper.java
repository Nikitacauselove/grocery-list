package com.sber.shoppinglist.list.model;

import com.sber.shoppinglist.list.dto.ShoppingListDto;
import com.sber.shoppinglist.list.dto.ShoppingListShortDto;
import com.sber.shoppinglist.user.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ShoppingListMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", source = "user")
    ShoppingList toShoppingList(User user, ShoppingListShortDto shoppingListShortDto);

    @Mapping(target = "items", source = "shoppingListShortDto.items")
    ShoppingList toShoppingList(ShoppingList shoppingList, ShoppingListShortDto shoppingListShortDto);

    ShoppingListDto toShoppingListDto(ShoppingList shoppingList);

    List<ShoppingListDto> toShoppingListDto(List<ShoppingList> shoppingLists);
}
