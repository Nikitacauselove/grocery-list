package com.sber.grocerylist.author.model;

import com.sber.grocerylist.author.dto.AuthorDto;
import com.sber.grocerylist.author.dto.AuthorShortDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    Author toAuthor(AuthorShortDto authorShortDto);

    AuthorDto toAuthorDto(Author author);

    List<AuthorDto> toAuthorDto(List<Author> authors);
}
