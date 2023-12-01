package com.sber.grocerylist.list;

import com.sber.grocerylist.list.model.GroceryList;
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
public class GroceryListService {
    private final GroceryListRepository groceryListRepository;

    public GroceryList create(GroceryList groceryList) {
        return groceryListRepository.save(groceryList);
    }

    public GroceryList update(Long id, GroceryList updatedGroceryList) {
        GroceryList groceryList = findById(id);

        groceryList.setItems(updatedGroceryList.getItems());
        return groceryList;
    }

    @Transactional(readOnly = true)
    public GroceryList findById(Long id) {
        return groceryListRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Список покупок с указанным идентификатором не найден"));
    }

    @Transactional(readOnly = true)
    public List<GroceryList> findAll() {
        return groceryListRepository.findAll();
    }

    public void deleteById(Long id) {
        groceryListRepository.deleteById(id);
    }
}
