package lsp.shop;

import java.util.*;

public class Trash implements Store {
    private final Set<Food> store = new HashSet<>();
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
