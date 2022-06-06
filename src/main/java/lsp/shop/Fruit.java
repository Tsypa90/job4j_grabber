package lsp.shop;

import java.util.Date;

public class Fruit extends Food {
    public Fruit(String name, Date expiryDate, Date createDate, int price, double discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
