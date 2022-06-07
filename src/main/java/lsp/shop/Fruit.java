package lsp.shop;

import java.time.LocalDate;

public class Fruit extends Food {
    public Fruit(String name, LocalDate expiryDate, LocalDate createDate, int price, double discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
