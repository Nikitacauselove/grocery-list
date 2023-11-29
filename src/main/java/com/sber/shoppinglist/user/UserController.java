package com.sber.shoppinglist.user;

import com.sber.shoppinglist.user.dto.UserDto;
import com.sber.shoppinglist.user.dto.UserShortDto;
import com.sber.shoppinglist.user.model.User;
import com.sber.shoppinglist.user.model.UserMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "users")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class UserController {
    private final UserMapper userMapper;
    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto create(@RequestBody @Valid UserShortDto userShortDto) {
        User user = userMapper.toUser(userShortDto);

        return userMapper.toUserDto(userService.create(user));
    }

    @PutMapping("/{id}")
    public UserDto update(@PathVariable Long id, @RequestBody @Valid UserShortDto userShortDto) {
        User user = userMapper.toUser(userService.findById(id), userShortDto);

        return userMapper.toUserDto(userService.update(user));
    }

    @GetMapping("/{id}")
    public UserDto findById(@PathVariable Long id) {
        return userMapper.toUserDto(userService.findById(id));
    }

    @GetMapping
    public List<UserDto> findAll() {
        return userMapper.toUserDto(userService.findAll());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        userService.deleteById(id);
    }
}
