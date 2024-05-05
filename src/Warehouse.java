package src;

import src.ingredient.Ingredient;
import src.ingredient.IngredientCheese;
import src.ingredient.IngredientTomato;
import src.ingredient.IngredientSchinken;
import src.pizza.PizzaInterface;

import java.util.ArrayList;

public class Warehouse {

    private IngredientTomato tomato;
    private IngredientCheese cheese;
    private IngredientSchinken schinken;

    private int alertThreshold;

    public Warehouse() {
        this.alertThreshold = 1000;
    }

    public boolean withdrawIngredients(Order order) {
        if (!this.isEnoughCapacityForOrder(order)) {
            return false;
        }
        // TODO implement the logic of withdrawing the ingredients from warehouse
        return true;
    }

    public boolean isThresholdViolated() {
        for (Ingredient ingredient : this.getIngredients()) {
            if (ingredient.getValue() < this.alertThreshold) {
                return true;
            }
        }
        return false;
    }

    private boolean isEnoughCapacityForOrder(Order order) {
        ArrayList<OrderItem> items = order.getItems();
        for (OrderItem item : items) {
            int pizzaQty = item.getQuantity();
            ArrayList<Ingredient> ingrs = item.getPizza().getIngredients();
            if (!this.isEnoughIngredients(ingrs, pizzaQty)) {
                return false;
            }
        }
        return true;
    }

    private boolean isEnoughIngredients(ArrayList<Ingredient> inputIngrs, int multiplier) {
        for (Ingredient inputIngr : inputIngrs) {
            for (Ingredient whIngr : this.getIngredients()) {
                if (inputIngr.getName().equals(whIngr.getName())) {
                    if (whIngr.getValue() < inputIngr.getValue() * multiplier) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private ArrayList<Ingredient> getIngredients() {
        ArrayList<Ingredient> ingrs = new ArrayList<>();
        ingrs.add(this.tomato);
        ingrs.add(this.cheese);
        ingrs.add(this.schinken);
        return ingrs;
    }

    public IngredientTomato getTomato() {
        return tomato;
    }

    public void setTomato(IngredientTomato tomato) {
        this.tomato = tomato;
    }

    public IngredientCheese getCheese() {
        return cheese;
    }

    public void setCheese(IngredientCheese cheese) {
        this.cheese = cheese;
    }

    public IngredientSchinken getSchinken() {
        return schinken;
    }

    public void setSchinken(IngredientSchinken schinken) {
        this.schinken = schinken;
    }

}
