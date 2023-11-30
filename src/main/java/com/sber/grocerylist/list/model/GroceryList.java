package com.sber.grocerylist.list.model;

import com.sber.grocerylist.item.model.GroceryItem;
import com.sber.grocerylist.author.model.Author;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Getter
@NoArgsConstructor
@Setter
@Table(name = "list")
public class GroceryList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Author author;

    @EqualsAndHashCode.Exclude
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "list_item",
            joinColumns = @JoinColumn(name = "list_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private Set<GroceryItem> items;

    public void addItem(GroceryItem groceryItem) {
        this.items.add(groceryItem);
        groceryItem.getLists().add(this);
    }

    public void removeItem(GroceryItem groceryItem) {
        this.items.remove(groceryItem);
        groceryItem.getLists().remove(this);
    }

    public void setItems(Set<GroceryItem> groceryItems) {
        if (this.items != null) {
            Set<GroceryItem> toRemove = this.items.stream().filter(item -> !groceryItems.contains(item)).collect(Collectors.toSet());
            Set<GroceryItem> toAdd = groceryItems.stream().filter(item -> !this.items.contains(item)).collect(Collectors.toSet());

            toRemove.forEach(this::removeItem);
            toAdd.forEach(this::addItem);
        } else {
            this.items = groceryItems;
        }
    }
}
