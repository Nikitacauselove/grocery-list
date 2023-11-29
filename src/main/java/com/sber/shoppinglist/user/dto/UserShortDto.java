package com.sber.shoppinglist.user.dto;


import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@RequiredArgsConstructor
@SuperBuilder
public class UserShortDto {
    @NotEmpty
    private final String name;

    @NotEmpty
    private final String surname;
}
