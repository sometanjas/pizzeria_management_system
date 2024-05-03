package src;

import java.util.ArrayList;

public class Pizza {
    public Recipe getRecipe() {
        return recipe;
    }

    private Recipe recipe;

    private int price;

    public Pizza(Recipe recipe) {
        this.recipe = recipe;
    }
}
