package src.pizza;

import src.ingredient.Ingredient;

import java.util.ArrayList;

public class PizzaMargaretta implements PizzaInterface {
    private Ingredient tomato;
    private Ingredient cheese;
    private Ingredient dough;
    private int priceCents;

    @Override
    public void build() throws Exception {
        this.tomato = Ingredient.NewTomatoIngredient(200);
        this.cheese = Ingredient.NewCheeseIngredient(100);
        this.dough = Ingredient.NewDoughIngredient(50);
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
