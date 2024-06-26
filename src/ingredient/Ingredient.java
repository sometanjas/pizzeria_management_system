package src.ingredient;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ingredient {

    public static List<String> getAllowedNames() {
        return new ArrayList<>(Arrays.asList(
                "cheese",
                "dough",
                "onion",
                "salmon",
                "schinken",
                "tomato",
                "tune"));
    }

    public int value;

    public String name;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Ingredient(String name, int value) throws Exception {
        if (!Ingredient.getAllowedNames().contains(name)) {
            throw new Exception("Unsupported ingredient: " + name);
        }
        this.name = name;
        this.value = value;
    }

    public static Ingredient NewCheeseIngredient(int value) throws Exception {
        return new Ingredient("cheese", value);
    }

    public static Ingredient NewDoughIngredient(int value) throws Exception {
        return new Ingredient("dough", value);
    }

    public static Ingredient NewOnionIngredient(int value) throws Exception {
        return new Ingredient("onion", value);
    }

    public static Ingredient NewSalmonIngredient(int value) throws Exception {
        return new Ingredient("salmon", value);
    }

    public static Ingredient NewSchinkenIngredient(int value) throws Exception {
        return new Ingredient("schinken", value);
    }

    public static Ingredient NewTomatoIngredient(int value) throws Exception {
        return new Ingredient("tomato", value);
    }

    public static Ingredient NewTuneIngredient(int value) throws Exception {
        return new Ingredient("tune", value);
    }
}
