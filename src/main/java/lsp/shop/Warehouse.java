package lsp.shop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Warehouse implements Store {
    private final List<Food> store = new ArrayList<>();
    private static final double LIFEPERCENTAGE = 0.25;

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
        return getPercentLifeExpired(food) < LIFEPERCENTAGE;
    }

    @Override
    public double getPercentLifeExpired(Food food) {
        return Store.super.getPercentLifeExpired(food);
    }
}
