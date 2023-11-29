package com.sber.grocerylist.list;

import com.sber.grocerylist.list.dto.GroceryListDto;
import com.sber.grocerylist.list.dto.GroceryListShortDto;
import com.sber.grocerylist.list.model.GroceryList;
import com.sber.grocerylist.list.model.GroceryListMapper;
import com.sber.grocerylist.user.UserService;
import com.sber.grocerylist.user.model.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "users/{userId}/lists")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class GroceryListController {
    private final GroceryListMapper groceryListMapper;
    private final GroceryListService groceryListService;
    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GroceryListDto create(@PathVariable Long userId, @RequestBody @Valid GroceryListShortDto groceryListShortDto) {
        GroceryList groceryList = groceryListMapper.toGroceryList(userService.findById(userId), groceryListShortDto);

        return groceryListMapper.toGroceryListDto(groceryListService.create(groceryList));
    }

    @PutMapping("/{listId}")
    public GroceryListDto update(@PathVariable Long userId, @PathVariable Long listId, @RequestBody @Valid GroceryListShortDto groceryListShortDto) {
        GroceryList updatedGroceryList = groceryListMapper.toGroceryList(userService.findById(userId), groceryListShortDto);

        return groceryListMapper.toGroceryListDto(groceryListService.update(listId, updatedGroceryList));
    }

    @GetMapping("/{listId}")
    public GroceryListDto findById(@PathVariable Long userId, @PathVariable Long listId) {
        userService.findById(userId);

        return groceryListMapper.toGroceryListDto(groceryListService.findById(listId));
    }

    @GetMapping
    public List<GroceryListDto> findAll(@PathVariable Long userId) {
        userService.findById(userId);

        return groceryListMapper.toGroceryListDto(groceryListService.findAll());
    }

    @DeleteMapping("/{listId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long userId, @PathVariable Long listId) {
        userService.findById(userId);
        groceryListService.deleteById(listId);
    }
}
