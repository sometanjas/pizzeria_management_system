package src;

import src.ingredient.IngredientCheese;
import src.ingredient.IngredientSchinken;
import src.ingredient.IngredientTomato;
import src.pizza.PizzaInterface;
import src.pizza.PizzaMargaretta;
import src.pizza.PizzaSchinken;

public class Main {
    public static void main(String[] args) {
        // Initialize Objects
        Warehouse warehouse = new Warehouse();
        warehouse.setCheese(new IngredientCheese(2000));
        warehouse.setSchinken(new IngredientSchinken(2000));
        warehouse.setTomato(new IngredientTomato(2000));
        // Create order functionality
        int qty = 1; // from input
        String pizzaName = "margaretta"; // from input
        PizzaInterface pizza;
        switch (pizzaName) {
            case "margaretta": {
                pizza = new PizzaMargaretta();
            }
            case "schinken": {
                pizza = new PizzaSchinken();
            }

            default: {
                throw Exception(); // if unrecognised input - return error
            }
        }
        pizza.build(); // initialize the ingredients and price

        OrderItem orderItem = new OrderItem(pizza, qty);
        Order order = new Order();
        order.addOrderItem(orderItem);

        boolean withdrawSuccess = warehouse.withdrawIngredients(order);
        if (!withdrawSuccess) {
            // handle insufficient ingredients' capacity in warehouse
        }

        if (warehouse.isThresholdViolated()) {
            // alert on the low volume (below threshold) of ingredient in warehouse
        }

        // save order to database
        // ...
        //

    }
}
