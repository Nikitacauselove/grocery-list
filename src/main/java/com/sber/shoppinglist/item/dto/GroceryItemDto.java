package com.sber.shoppinglist.item.dto;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class GroceryItemDto extends GroceryItemShortDto {
    private final Long id;
}
