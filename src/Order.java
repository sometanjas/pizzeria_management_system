package src;

import java.util.ArrayList;

public class Order {
    private ArrayList<OrderItem> items;

    public ArrayList<OrderItem> getItems() {
        return items;
    }

    public void addOrderItem(OrderItem item) {
        this.items.add(item);
    }
}
