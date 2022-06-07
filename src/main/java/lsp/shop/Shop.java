package lsp.shop;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Store {
    private final List<Food> store = new ArrayList<>();
    private static final double LIFEPERCENTAGEWEARHOUSE = 0.25;
    private static final double LIFEPERCENTAGESHOP = 0.75;
    private static final double LIFEPERCENTAGETRASH = 1;
    @Override
    public boolean add(Food food) {
        boolean rsl = accept(food);
        if (rsl) {
            if (getPercentLifeExpired(food) > LIFEPERCENTAGESHOP) {
                food.setPrice(food.getPrice() * (1 - food.getDiscount()));
                store.add(food);
            } else {
                store.add(food);
            }
        }
        return rsl;
    }

    @Override
    public List<Food> getStore() {
        return new ArrayList<>(store);
    }

    @Override
    public boolean accept(Food food) {
        return getPercentLifeExpired(food) >= LIFEPERCENTAGEWEARHOUSE
                && getPercentLifeExpired(food) <= LIFEPERCENTAGETRASH;
    }

    @Override
    public double getPercentLifeExpired(Food food) {
        return Store.super.getPercentLifeExpired(food);
    }
}