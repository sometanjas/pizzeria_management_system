package src;

import src.pizza.PizzaInterface;

public class OrderItem {
    private PizzaInterface pizza;
    private int quantity;

    public PizzaInterface getPizza() {
        return pizza;
    }

    public int getQuantity() {
        return quantity;
    }


    public OrderItem(PizzaInterface pizza, int quantity) {
        this.pizza = pizza;
        this.quantity = quantity;
    }
}
