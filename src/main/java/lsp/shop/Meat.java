package lsp.shop;

import java.util.Date;

public class Meat extends Food {
    public Meat(String name, Date expiryDate, Date createDate, int price, double discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
