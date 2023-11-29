package com.sber.grocerylist.list.model;

import com.sber.grocerylist.item.GroceryItemService;
import com.sber.grocerylist.item.model.GroceryItem;
import com.sber.grocerylist.list.dto.GroceryListDto;
import com.sber.grocerylist.list.dto.GroceryListShortDto;
import com.sber.grocerylist.user.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class GroceryListMapper {
    @Autowired
    private GroceryItemService groceryItemService;

    public GroceryList toGroceryList(User user, GroceryListShortDto groceryListShortDto) {
        List<GroceryItem> items = groceryItemService.findAllByName(groceryListShortDto.getItems());

        return new GroceryList(null, user, new HashSet<>(items));
    }

    public GroceryListDto toGroceryListDto(GroceryList groceryList) {
        List<String> ids = groceryList.getItems().stream().map(GroceryItem::getName).toList();

        GroceryListDto.GroceryListDtoBuilder<?, ?> groceryListDto = GroceryListDto.builder();

        groceryListDto.items( ids );
        groceryListDto.id( groceryList.getId() );

        return groceryListDto.build();
    }

    public abstract List<GroceryListDto> toGroceryListDto(List<GroceryList> groceryLists);
}
