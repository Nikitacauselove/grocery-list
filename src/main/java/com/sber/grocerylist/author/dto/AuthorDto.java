package com.sber.grocerylist.author.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Getter
@SuperBuilder
@ToString
public class AuthorDto extends AuthorShortDto {
    private Long id;
}
