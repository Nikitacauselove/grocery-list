package com.sber.grocerylist.author.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Getter
@SuperBuilder
public class AuthorDto extends AuthorShortDto {
    private Long id;
}
