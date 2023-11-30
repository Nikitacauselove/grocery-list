package com.sber.grocerylist.list.dto;

import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode
@Getter
@NoArgsConstructor
@SuperBuilder
public class GroceryListShortDto {
    @NotNull
    private List<String> items;
}
