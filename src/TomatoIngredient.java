package src;

public class TomatoIngredient implements Ingredient {

    private int gramms;

    public TomatoIngredient(int gramms) {
        this.gramms = gramms;
    }

    @Override
    public int GetQuantity() {
        return this.gramms;
    }
}
