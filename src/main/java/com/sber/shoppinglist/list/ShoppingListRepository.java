package com.sber.shoppinglist.list;

import com.sber.shoppinglist.list.model.ShoppingList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingListRepository extends JpaRepository<ShoppingList, Long> {
}
