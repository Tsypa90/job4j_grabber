package lsp.shop;

import java.util.List;

public interface Store {
    boolean add(Food food);

    List<Food> getStore();
}
