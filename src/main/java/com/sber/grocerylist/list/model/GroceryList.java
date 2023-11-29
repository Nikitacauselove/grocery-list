package com.sber.grocerylist.list.model;

import com.sber.grocerylist.item.model.GroceryItem;
import com.sber.grocerylist.user.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
@Table(name = "grocery_lists")
public class GroceryList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToMany (cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "grocery_list_items",
            joinColumns = @JoinColumn(name="grocery_list_id"),
            inverseJoinColumns = @JoinColumn(name="grocery_item_id")
    )
    private Set<GroceryItem> items;

    public void setItems(Set<GroceryItem> items) {
        Set<GroceryItem> toRemove = this.items.stream().filter(item -> !items.contains(item)).collect(Collectors.toSet());
        Set<GroceryItem> toAdd = items.stream().filter(item -> !this.items.contains(item)).collect(Collectors.toSet());

        toRemove.forEach(this::removeItem);
        toAdd.forEach(this::addItem);
    }

    private void addItem(GroceryItem groceryItem) {
        this.items.add(groceryItem);
        groceryItem.getLists().add(this);
    }

    private void removeItem(GroceryItem groceryItem) {
        this.items.remove(groceryItem);
        groceryItem.getLists().remove(this);
    }

    @Override
    public int hashCode() {
        return Math.toIntExact(id);
    }
}
