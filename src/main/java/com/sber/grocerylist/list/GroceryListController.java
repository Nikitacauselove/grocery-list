package com.sber.grocerylist.list;

import com.sber.grocerylist.item.GroceryItemService;
import com.sber.grocerylist.item.model.GroceryItem;
import com.sber.grocerylist.list.dto.GroceryListDto;
import com.sber.grocerylist.list.dto.GroceryListShortDto;
import com.sber.grocerylist.list.model.GroceryList;
import com.sber.grocerylist.list.model.GroceryListMapper;
import com.sber.grocerylist.author.AuthorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "authors/{authorId}/lists")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class GroceryListController {
    private final AuthorService authorService;
    private final GroceryItemService groceryItemService;
    private final GroceryListService groceryListService;
    private final GroceryListMapper groceryListMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GroceryListDto create(@PathVariable Long authorId, @RequestBody @Valid GroceryListShortDto groceryListShortDto) {
        List<GroceryItem> items = groceryItemService.findAllByNameIn(groceryListShortDto.getItems());
        GroceryList groceryList = groceryListMapper.toGroceryList(authorService.findById(authorId), items);

        return groceryListMapper.toGroceryListDto(groceryListService.create(groceryList));
    }

    @PutMapping("/{listId}")
    public GroceryListDto update(@PathVariable Long authorId, @PathVariable Long listId, @RequestBody @Valid GroceryListShortDto groceryListShortDto) {
        List<GroceryItem> items = groceryItemService.findAllByNameIn(groceryListShortDto.getItems());
        GroceryList updatedGroceryList = groceryListMapper.toGroceryList(authorService.findById(authorId), items);

        return groceryListMapper.toGroceryListDto(groceryListService.update(listId, updatedGroceryList));
    }

    @GetMapping("/{listId}")
    public GroceryListDto findById(@PathVariable Long authorId, @PathVariable Long listId) {
        authorService.findById(authorId);

        return groceryListMapper.toGroceryListDto(groceryListService.findById(listId));
    }

    @GetMapping
    public List<GroceryListDto> findAll(@PathVariable Long authorId) {
        authorService.findById(authorId);

        return groceryListMapper.toGroceryListDto(groceryListService.findAll());
    }

    @DeleteMapping("/{listId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long authorId, @PathVariable Long listId) {
        authorService.findById(authorId);
        groceryListService.deleteById(listId);
    }
}
