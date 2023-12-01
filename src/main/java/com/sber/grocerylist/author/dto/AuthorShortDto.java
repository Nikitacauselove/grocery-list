package com.sber.grocerylist.author.dto;

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
public class AuthorShortDto {
    @NotEmpty(message = "Имя автора не может быть пустым")
    @Size(max = 255, message = "Имя автора не может быть длиннее 255 символов")
    private String name;

    @NotEmpty(message = "Фамилия автора не может быть пустой")
    @Size(max = 255, message = "Фамилия автора не может быть длиннее 255 символов")
    private String surname;
}
