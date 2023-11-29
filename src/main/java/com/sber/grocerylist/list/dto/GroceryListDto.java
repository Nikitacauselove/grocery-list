package com.sber.grocerylist.list.dto;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class GroceryListDto extends GroceryListShortDto {
    private final Long id;
}
