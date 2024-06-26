package src.pizza;

import src.ingredient.*;

import java.util.ArrayList;

public class PizzaSchinken implements PizzaInterface {
    private Ingredient tomato;
    private Ingredient cheese;
    private Ingredient schinken;
    private Ingredient dough;
    private int priceCents;

    @Override
    public void build() throws Exception {
        this.tomato = Ingredient.NewOnionIngredient(200);
        this.cheese = Ingredient.NewCheeseIngredient(100);
        this.schinken = Ingredient.NewSchinkenIngredient(100);
        this.dough = Ingredient.NewDoughIngredient(50);
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
