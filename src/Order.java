package src;

import java.util.ArrayList;

public class Order {
    private ArrayList<OrderItem> items;

    public ArrayList<OrderItem> getItems() {
        return items;
    }

    public Order(ArrayList<OrderItem> items) {
        this.items = items;
    }

//    public ArrayList<Ingredient> getTotalIngredients() {
//        for (int i = 0; i < this.items.size(); i++) {
//            int pizzaQty = this.items.get(i).getQuantity();
//
//            ArrayList<Ingredient> pizzaIngredients = this.items.get(i).getPizza().getRecipe().getIngredients();
//            for (int j = 0; j < pizzaIngredients.size(); j++) {
//
//            }
//        }
//    }
}
