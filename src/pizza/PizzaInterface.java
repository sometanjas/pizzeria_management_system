package src.pizza;

import src.ingredient.Ingredient;

import java.util.ArrayList;

public interface PizzaInterface {
    void build();

    int getPrice();

    ArrayList<Ingredient> getIngredients();
}
