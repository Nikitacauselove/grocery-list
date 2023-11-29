package com.sber.shoppinglist.list;

import com.sber.shoppinglist.list.dto.ShoppingListDto;
import com.sber.shoppinglist.list.dto.ShoppingListShortDto;
import com.sber.shoppinglist.list.model.ShoppingList;
import com.sber.shoppinglist.list.model.ShoppingListMapper;
import com.sber.shoppinglist.user.UserService;
import com.sber.shoppinglist.user.model.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "users/{userId}/lists")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ShoppingListController {
    private final ShoppingListMapper shoppingListMapper;
    private final ShoppingListService shoppingListService;
    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ShoppingListDto create(@PathVariable Long userId, @RequestBody @Valid ShoppingListShortDto shoppingListShortDto) {
        User user = userService.findById(userId);
        ShoppingList shoppingList = shoppingListMapper.toShoppingList(user, shoppingListShortDto);

        return shoppingListMapper.toShoppingListDto(shoppingListService.create(shoppingList));
    }

    @PutMapping("/{listId}")
    public ShoppingListDto update(@PathVariable Long userId, @PathVariable Long listId, @RequestBody @Valid ShoppingListShortDto shoppingListShortDto) {
        userService.findById(userId);
        ShoppingList shoppingList = shoppingListMapper.toShoppingList(shoppingListService.findById(listId), shoppingListShortDto);

        return shoppingListMapper.toShoppingListDto(shoppingListService.update(shoppingList));
    }

    @GetMapping("/{listId}")
    public ShoppingListDto findById(@PathVariable Long userId, @PathVariable Long listId) {
        userService.findById(userId);

        return shoppingListMapper.toShoppingListDto(shoppingListService.findById(listId));
    }

    @GetMapping
    public List<ShoppingListDto> findAll(@PathVariable Long userId) {
        userService.findById(userId);

        return shoppingListMapper.toShoppingListDto(shoppingListService.findAll());
    }

    @DeleteMapping("/{listId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long userId, @PathVariable Long listId) {
        userService.findById(userId);
        shoppingListService.deleteById(listId);
    }
}
