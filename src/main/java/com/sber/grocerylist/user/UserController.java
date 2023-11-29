package com.sber.grocerylist.user;

import com.sber.grocerylist.user.dto.UserDto;
import com.sber.grocerylist.user.dto.UserShortDto;
import com.sber.grocerylist.user.model.User;
import com.sber.grocerylist.user.model.UserMapper;
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

    @PutMapping("/{userId}")
    public UserDto update(@PathVariable Long userId, @RequestBody @Valid UserShortDto userShortDto) {
        User user = userMapper.toUser(userService.findById(userId), userShortDto);

        return userMapper.toUserDto(userService.update(user));
    }

    @GetMapping("/{userId}")
    public UserDto findById(@PathVariable Long userId) {
        return userMapper.toUserDto(userService.findById(userId));
    }

    @GetMapping
    public List<UserDto> findAll() {
        return userMapper.toUserDto(userService.findAll());
    }

    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long userId) {
        userService.deleteById(userId);
    }
}
