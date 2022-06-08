package lsp.shop;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Store {
    private final List<Food> store = new ArrayList<>();
    private static final double LIFE_PERCENTAGE_TRASH = 1;
    @Override
    public boolean add(Food food) {
        return accept(food) ? store.add(food) : false;
    }

    @Override
    public List<Food> getStore() {
        return new ArrayList<>(store);
    }

    @Override
    public boolean accept(Food food) {
        return getPercentLifeExpired(food) > LIFE_PERCENTAGE_TRASH;
    }
}
