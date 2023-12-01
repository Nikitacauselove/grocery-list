package com.sber.grocerylist.item.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode
@Getter
@NoArgsConstructor
@SuperBuilder
@ToString
public class GroceryItemShortDto {
    @NotEmpty
    @Size(max = 255)
    private String name;
}
