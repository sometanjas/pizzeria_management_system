package src;

import java.util.ArrayList;

public class Warehouse {

    private TomatoIngredient tomato;
    private CheeseIngredient cheese;

    public boolean isEnoughCapacityForOrder(Order order) {
        ArrayList<OrderItem> items = order.getItems();
        for (int i = 0; i < items.size(); i++) {
            OrderItem item = items.get(i);
            int pizzaQty = item.getQuantity();

            CheeseIngredient cheese = item.getPizza().getRecipe().getCheese();
            if (cheese.GetQuantity() * pizzaQty > this.cheese.GetQuantity()) {
                // TO-DO
                return true;
            }

        }
        return true;
    }
}
