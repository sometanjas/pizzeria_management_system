package src;

import java.util.ArrayList;

public class Recipe {
    private TomatoIngredient tomato;
    private CheeseIngredient cheese;

    public TomatoIngredient getTomato() {
        return tomato;
    }

    public CheeseIngredient getCheese() {
        return cheese;
    }

    public void withTomatoes(TomatoIngredient item) {
        this.tomato = item;
    }

    public void withCheese(CheeseIngredient item) {
        this.cheese = item;
    }

//    public ArrayList<Ingredient> getIngredients() {
//        return ingredients;
//    }

//    private ArrayList<Ingredient> ingredients;

//    public void withTomatoes(TomatoIngredient item) {
//        this.ingredients.add(item);
//    }
//
//    public void withCheese(CheeseIngredient item) {
//        this.ingredients.add(item);
//    }
}
