package lsp.shop;

import java.util.*;

public class Shop implements Store {
    private final Set<Food> store = new HashSet<>();
    private static final double LIFE_PERCENTAGE_WAREHOUSE = 0.25;
    private static final double LIFE_PERCENTAGE_SHOP = 0.75;
    private static final double LIFE_PERCENTAGE_TRASH = 1;
    @Override
    public boolean add(Food food) {
        boolean rsl = accept(food);
        if (rsl) {
            if (getPercentLifeExpired(food) > LIFE_PERCENTAGE_SHOP) {
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
        return getPercentLifeExpired(food) >= LIFE_PERCENTAGE_WAREHOUSE
                && getPercentLifeExpired(food) <= LIFE_PERCENTAGE_TRASH;
    }
}