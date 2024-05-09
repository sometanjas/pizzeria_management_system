package src.pizza;

import src.ingredient.*;

import java.util.ArrayList;

public class PizzaSalmone implements PizzaInterface {
    private IngredientOnion onion;
    private IngredientCheese cheese;
    private IngredientSalmon salmon;
    private IngredientDough dough;
    private int priceCents;

    @Override
    public void build() {
        this.onion = new IngredientOnion(200);
        this.cheese = new IngredientCheese(100);
        this.salmon = new IngredientSalmon(100);
        this.dough = new IngredientDough(50);
        this.priceCents = 1590;
    }

    @Override
    public int getPrice() {
        return priceCents;
    }

    @Override
    public ArrayList<Ingredient> getIngredients() {
        ArrayList<Ingredient> ingrs = new ArrayList<>();
        ingrs.add(this.onion);
        ingrs.add(this.cheese);
        ingrs.add(this.salmon);
        ingrs.add(this.dough);
        return ingrs;
    }
}
