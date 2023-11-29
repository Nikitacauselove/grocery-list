package com.sber.grocerylist.list.model;

import com.sber.grocerylist.list.dto.GroceryListDto;
import com.sber.grocerylist.list.dto.GroceryListShortDto;
import com.sber.grocerylist.user.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface GroceryListMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", source = "user")
    GroceryList toGroceryList(User user, GroceryListShortDto groceryListShortDto);

    @Mapping(target = "items", source = "groceryListShortDto.items")
    GroceryList toGroceryList(GroceryList groceryList, GroceryListShortDto groceryListShortDto);

    GroceryListDto toGroceryListDto(GroceryList groceryList);

    List<GroceryListDto> toGroceryListDto(List<GroceryList> groceryLists);
}
