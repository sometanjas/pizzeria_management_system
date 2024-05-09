package src.pizza;

import src.ingredient.*;

import java.util.ArrayList;

public class PizzaFruttiDiMare implements PizzaInterface {
    private IngredientFruttiDiMare fruttiDiMare;
    private IngredientCheese cheese;

    private IngredientDough dough;
    private int priceCents;

    @Override
    public void build() {
        this.fruttiDiMare = new IngredientFruttiDiMare(200);
        this.cheese = new IngredientCheese(100);
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
        ingrs.add(this.fruttiDiMare);
        ingrs.add(this.cheese);
        ingrs.add(this.dough);
        return ingrs;
    }
}
