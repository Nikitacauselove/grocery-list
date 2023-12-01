package com.sber.grocerylist.item.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Getter
@SuperBuilder
@ToString
public class GroceryItemDto extends GroceryItemShortDto {
    private Long id;
}
