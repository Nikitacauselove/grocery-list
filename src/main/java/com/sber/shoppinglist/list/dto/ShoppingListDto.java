package com.sber.shoppinglist.list.dto;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class ShoppingListDto extends ShoppingListShortDto {
    private final Long id;
}
