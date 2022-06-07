package lsp.shop;

import java.time.LocalDate;

public class Milk extends Food {
    public Milk(String name, LocalDate expiryDate, LocalDate createDate, int price, double discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
