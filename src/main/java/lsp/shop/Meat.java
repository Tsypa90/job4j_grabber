package lsp.shop;

import java.time.LocalDate;

public class Meat extends Food {
    public Meat(String name, LocalDate expiryDate, LocalDate createDate, int price, double discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
