package src;

import src.ingredient.*;
import src.pizza.PizzaInterface;

import java.util.ArrayList;

public class Warehouse {

    private IngredientTomato tomato;
    private IngredientCheese cheese;
    private IngredientSchinken schinken;
    private IngredientDough dough;
    private IngredientTuna tuna;
    private IngredientSalmon salmon;
    private IngredientOnion onion;
    private int alertThreshold;

    public Warehouse() {
        this.tomato = new IngredientTomato(1000);
        this.cheese = new IngredientCheese(1000);
        this.schinken = new IngredientSchinken(1000);
        this.dough = new IngredientDough(1000);
        this.tuna = new IngredientTuna(1000);
        this.salmon = new IngredientSalmon(1000);
        this.onion =  new IngredientOnion(1000);
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
        ingrs.add(this.tuna);
        ingrs.add(this.dough);
        ingrs.add(this.salmon);
        ingrs.add(this.onion);
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

    public IngredientDough getDough() {
        return dough;
    }

    public void setDough(IngredientDough dough) {
        this.dough = dough;
    }

    public IngredientTuna getTuna() {
        return tuna;
    }

    public void setTuna(IngredientTuna tuna) {
        this.tuna = tuna;
    }

    public IngredientSalmon getSalmon() {
        return salmon;
    }

    public void setSalmon(IngredientSalmon salmon) {
        this.salmon = salmon;
    }

    public IngredientOnion getOnion() {
        return onion;
    }

    public void setOnion(IngredientOnion onion) {
        this.onion = onion;
    }
}
