package com.sber.grocerylist.list.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Getter
@SuperBuilder
public class GroceryListDto extends GroceryListShortDto {
    private Long id;
}
