package com.sber.shoppinglist.item;

import com.sber.shoppinglist.item.model.GroceryItem;
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
public class GroceryItemService {
    private final GroceryItemRepository groceryItemRepository;

    public GroceryItem create(GroceryItem groceryItem) {
        return groceryItemRepository.save(groceryItem);
    }

    public GroceryItem update(GroceryItem groceryItem) {
        return groceryItemRepository.save(groceryItem);
    }

    @Transactional(readOnly = true)
    public GroceryItem findById(Long id) {
        return groceryItemRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Товар с указанным идентификатором не найден"));
    }

    @Transactional(readOnly = true)
    public List<GroceryItem> findAll() {
        return groceryItemRepository.findAllByOrderById();
    }

    public void deleteById(Long id) {
        groceryItemRepository.deleteById(id);
    }
}
