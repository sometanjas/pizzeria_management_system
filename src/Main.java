package src;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Recipe margaritaRecipe = new Recipe();
        margaritaRecipe.withTomatoes(new TomatoIngredient(100));
        margaritaRecipe.withCheese(new CheeseIngredient(50));

        Recipe tomatoPizzaRecipe = new Recipe();
        margaritaRecipe.withTomatoes(new TomatoIngredient(100));

        Pizza margaritta = new Pizza(margaritaRecipe);
        Pizza tomatoPizza = new Pizza(tomatoPizzaRecipe);

        OrderItem margarittaPosition = new OrderItem(margaritta, 2);
        OrderItem tomatoPizzaPosition = new OrderItem(margaritta, 1);

        ArrayList<OrderItem> items = new ArrayList<>();
        items.add(margarittaPosition);
        items.add(tomatoPizzaPosition);
        Order order = new Order(items);




        System.out.println("goodbye world");
    }
}
