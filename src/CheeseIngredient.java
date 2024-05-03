package src;

public class CheeseIngredient implements Ingredient {

    private int gramms;

    public CheeseIngredient(int gramms) {
        this.gramms = gramms;
    }

    @Override
    public int GetQuantity() {
        return this.gramms;
    }
}
