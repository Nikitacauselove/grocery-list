package com.sber.grocerylist.list;

import com.sber.grocerylist.list.model.GroceryList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroceryListRepository extends JpaRepository<GroceryList, Long> {
}
