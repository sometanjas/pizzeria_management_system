package src.storage.warehouse;

import src.ingredient.Ingredient;

import java.util.List;

public interface WarehouseDao {
    List<Ingredient> getAllIngredients();

    void withdrawIngredient(String name, int delta);

    void depositIngredient(String name, int delta);

    void addIngredient(String name, int delta);
}
