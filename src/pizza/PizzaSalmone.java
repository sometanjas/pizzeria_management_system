package src.pizza;

import src.ingredient.*;

import java.util.ArrayList;

public class PizzaSalmone implements PizzaInterface {
    private Ingredient onion;
    private Ingredient cheese;
    private Ingredient salmon;
    private Ingredient dough;
    private int priceCents;

    @Override
    public void build() throws Exception {
        this.onion = Ingredient.NewOnionIngredient(200);
        this.cheese = Ingredient.NewCheeseIngredient(100);
        this.salmon = Ingredient.NewSalmonIngredient(100);
        this.dough = Ingredient.NewDoughIngredient(50);
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

    @Override
    public String getName() {
        return "Pizza Salmone";
    }
}
