package com.sber.grocerylist.user.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@RequiredArgsConstructor
@SuperBuilder
public class UserShortDto {
    @NotEmpty
    @Size(max = 255)
    private final String name;

    @NotEmpty
    @Size(max = 255)
    private final String surname;
}
