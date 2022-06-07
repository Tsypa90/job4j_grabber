package lsp.shop;

import java.time.LocalDate;
import java.util.List;

public interface Store {
    boolean add(Food food);

    List<Food> getStore();

    boolean accept(Food food);

    default double getPercentLifeExpired(Food food) {
        int expiryDays = food.getExpiryDate().getDayOfYear() - food.getCreateDate().getDayOfYear();
        int percentage = LocalDate.now().getDayOfYear() - food.getCreateDate().getDayOfYear();
        return (double) percentage / expiryDays;
    }
}
