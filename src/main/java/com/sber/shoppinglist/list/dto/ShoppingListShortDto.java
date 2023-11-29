package com.sber.shoppinglist.list.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@RequiredArgsConstructor
@SuperBuilder
public class ShoppingListShortDto {
    private final String hack;

    @NotEmpty
    @Size(max = 255)
    private final String items;
}
