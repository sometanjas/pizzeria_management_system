package src.pizza;

import src.ingredient.Ingredient;

import java.util.ArrayList;

public interface PizzaInterface {
    void build() throws Exception;

    int getPrice();

    String getName();

    ArrayList<Ingredient> getIngredients();
}
