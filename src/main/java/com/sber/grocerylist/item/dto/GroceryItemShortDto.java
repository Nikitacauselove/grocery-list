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
    @NotEmpty(message = "Название товара не может быть пустым")
    @Size(max = 255, message = "Название товара не может быть длиннее 255 символов")
    private String name;
}
