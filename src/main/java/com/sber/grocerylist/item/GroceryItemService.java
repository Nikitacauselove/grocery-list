package com.sber.grocerylist.item;

import com.sber.grocerylist.exception.NotFoundException;
import com.sber.grocerylist.item.model.GroceryItem;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Service
@Transactional
public class GroceryItemService {
    private final GroceryItemRepository groceryItemRepository;

    public GroceryItem create(GroceryItem groceryItem) {
        return groceryItemRepository.save(groceryItem);
    }

    public GroceryItem update(Long id, GroceryItem updatedGroceryItem) {
        GroceryItem groceryItem = findById(id);

        groceryItem.setName(updatedGroceryItem.getName());
        return groceryItem;
    }

    @Transactional(readOnly = true)
    public GroceryItem findById(Long id) {
        return groceryItemRepository.findById(id).orElseThrow(() -> new NotFoundException("Товар с указанным идентификатором не найден"));
    }

    @Transactional(readOnly = true)
    public List<GroceryItem> findAllByOrderById() {
        return groceryItemRepository.findAllByOrderById();
    }

    @Transactional(readOnly = true)
    public List<GroceryItem> findAllByNameIn(Iterable<String> names) {
        return groceryItemRepository.findAllByNameIn(names);
    }

    public void deleteById(Long id) {
        groceryItemRepository.deleteById(id);
    }
}
