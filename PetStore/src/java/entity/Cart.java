/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.text.DecimalFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author PHT
 */
public class Cart {

    private Map<Integer, Item> map;

    public Cart() {
        map = new HashMap<>();
    }

    public void add(Item item) {
        int id = item.getProducts().getId();
        if (map.containsKey(id)) {
            Item oldItem = map.get(id);
            oldItem.setQuantity(oldItem.getQuantity() + item.getQuantity());
        } else {
            map.put(id, item);
        }
    }

    public void update(int id, int quantity) {
        Item item = map.get(id);
        if (item != null) {
            item.setQuantity(quantity);
        } else {
            // handle error case (e.g. log error message)
        }
    }

    public void remove(int id) {
        map.remove(id);
    }

    public void empty() {
        map.clear();
    }

    public Collection<Item> getItems() {
        return map.values();
    }

    public double getTotal() {
        double total = 0;
        for (Item item : map.values()) {
            total += item.getCost();
        }
        return Math.round(total * 100.0) / 100.0;
    }

    public int getTotalQuantity() {
        int totalQuantity = 0;
        for (Item item : map.values()) {
            totalQuantity += item.getQuantity();
        }
        return totalQuantity;
    }
    
    public boolean contains(int id) {
        return map.containsKey(id);
    }
}
