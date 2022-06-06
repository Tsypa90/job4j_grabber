package lsp.shop;

import java.util.Date;

public class Bread extends Food {
    public Bread(String name, Date expiryDate, Date createDate, int price, double discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
