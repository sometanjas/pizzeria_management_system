package src.pizza;

import src.ingredient.Ingredient;
import src.ingredient.IngredientCheese;
import src.ingredient.IngredientDough;
import src.ingredient.IngredientTomato;

import java.util.ArrayList;

public class PizzaMargaretta implements PizzaInterface {
    private IngredientTomato tomato;
    private IngredientCheese cheese;
    private IngredientDough dough;
    private int priceCents;

    @Override
    public void build() {
        this.tomato = new IngredientTomato(200);
        this.cheese = new IngredientCheese(100);
        this.dough = new IngredientDough(50);
        this.priceCents = 890;
    }

    @Override
    public int getPrice() {
        return priceCents;
    }

    @Override
    public String getName() {
        return "Pizza Margaretta";
    }

    @Override
    public ArrayList<Ingredient> getIngredients() {
        ArrayList<Ingredient> ingrs = new ArrayList<>();
        ingrs.add(this.tomato);
        ingrs.add(this.cheese);
        ingrs.add(this.dough);
        return ingrs;
    }
}
