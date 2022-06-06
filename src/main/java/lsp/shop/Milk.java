package lsp.shop;

import java.util.Date;

public class Milk extends Food {
    public Milk(String name, Date expiryDate, Date createDate, int price, double discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
