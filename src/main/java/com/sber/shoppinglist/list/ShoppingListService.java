package com.sber.shoppinglist.list;

import com.sber.shoppinglist.list.model.ShoppingList;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Service
@Transactional
public class ShoppingListService {
    private final ShoppingListRepository shoppingListRepository;

    public ShoppingList create(ShoppingList shoppingList) {
        return shoppingListRepository.save(shoppingList);
    }

    public ShoppingList update(ShoppingList shoppingList) {
        return shoppingListRepository.save(shoppingList);
    }

    @Transactional(readOnly = true)
    public ShoppingList findById(Long id) {
        return shoppingListRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Список покупок с указанным идентификатором не найден"));
    }

    @Transactional(readOnly = true)
    public List<ShoppingList> findAll() {
        return shoppingListRepository.findAll();
    }

    public void deleteById(Long id) {
        shoppingListRepository.deleteById(id);
    }
}
