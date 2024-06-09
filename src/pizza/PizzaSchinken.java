package src.pizza;

import src.ingredient.*;

import java.util.ArrayList;

public class PizzaSchinken implements PizzaInterface {
    private IngredientTomato tomato;
    private IngredientCheese cheese;
    private IngredientSchinken schinken;
    private IngredientDough dough;
    private int priceCents;

    @Override
    public void build() {
        this.tomato = new IngredientTomato(200);
        this.cheese = new IngredientCheese(100);
        this.schinken = new IngredientSchinken(100);
        this.dough = new IngredientDough(50);
        this.priceCents = 900;
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
        ingrs.add(this.schinken);
        ingrs.add(this.dough);
        return ingrs;
    }

    @Override
    public String getName() {
        return "Pizza Schinken";
    }
}
