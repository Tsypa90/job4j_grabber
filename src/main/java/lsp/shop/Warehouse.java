package lsp.shop;

import java.util.*;

public class Warehouse implements Store {
    private final List<Food> store = new ArrayList<>();
    private static final double LIFE_PERCENTAGE = 0.25;

    @Override
    public boolean add(Food food) {
        return accept(food) ? store.add(food) : false;
    }

    @Override
    public List<Food> getStore() {
        return new ArrayList<>(store);
    }

    @Override
    public void clear() {
        store.clear();
    }

    @Override
    public boolean accept(Food food) {
        return getPercentLifeExpired(food) < LIFE_PERCENTAGE;
    }
}
