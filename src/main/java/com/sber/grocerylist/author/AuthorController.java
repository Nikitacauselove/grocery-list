package com.sber.grocerylist.author;

import com.sber.grocerylist.author.dto.AuthorDto;
import com.sber.grocerylist.author.dto.AuthorShortDto;
import com.sber.grocerylist.author.model.Author;
import com.sber.grocerylist.author.model.AuthorMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "authors")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class AuthorController {
    private final AuthorService authorService;
    private final AuthorMapper authorMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AuthorDto create(@RequestBody @Valid AuthorShortDto authorShortDto) {
        Author author = authorMapper.toAuthor(authorShortDto);

        return authorMapper.toAuthorDto(authorService.create(author));
    }

    @PutMapping("/{authorId}")
    public AuthorDto update(@PathVariable Long authorId, @RequestBody @Valid AuthorShortDto authorShortDto) {
        Author updatedAuthor = authorMapper.toAuthor(authorShortDto);

        return authorMapper.toAuthorDto(authorService.update(authorId, updatedAuthor));
    }

    @GetMapping("/{authorId}")
    public AuthorDto findById(@PathVariable Long authorId) {
        return authorMapper.toAuthorDto(authorService.findById(authorId));
    }

    @GetMapping
    public List<AuthorDto> findAll() {
        return authorMapper.toAuthorDto(authorService.findAll());
    }

    @DeleteMapping("/{authorId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long authorId) {
        authorService.deleteById(authorId);
    }
}
