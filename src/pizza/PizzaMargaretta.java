package src.pizza;

import src.ingredient.Ingredient;
import src.ingredient.IngredientCheese;
import src.ingredient.IngredientTomato;

import java.util.ArrayList;

public class PizzaMargaretta implements PizzaInterface {
    private IngredientTomato tomato;
    private IngredientCheese cheese;
    private int priceCents;

    @Override
    public void build() {
        this.tomato = new IngredientTomato(200);
        this.cheese = new IngredientCheese(100);
        this.priceCents = 500;
    }

    @Override
    public int getPrice() {
        return priceCents;
    }

    @Override
    public ArrayList<Ingredient> getIngredients() {
        ArrayList<Ingredient> ingrs = new ArrayList<>();
        ingrs.add(this.tomato);
        ingrs.add(this.cheese);
        return ingrs;
    }
}
