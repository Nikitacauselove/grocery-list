package com.sber.grocerylist.list.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Getter
@SuperBuilder
@ToString
public class GroceryListDto extends GroceryListShortDto {
    private Long id;
}
