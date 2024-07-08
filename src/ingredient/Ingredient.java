package src.ingredient;

import java.util.*;

public class Ingredient {

    public static Map<String, Integer> getAvailableValues() {
        return new HashMap<>() {{
            put("cheese", 500);
            put("dough", 300);
            put("onion", 300);
            put("salmon", 1500);
            put("schinken", 1000);
            put("tomato", 500);
            put("tune", 800);
        }};
    }

    private int value;

    private String name;

    private int price;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Ingredient(String name, int value) throws Exception {
        Map<String, Integer> availableValues = Ingredient.getAvailableValues();
        if (!availableValues.containsKey(name)) {
            throw new Exception("Unsupported ingredient: " + name);
        }
        this.name = name;
        this.price = availableValues.get(name);
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
