package lsp.shop;

import java.util.Calendar;
import java.util.Date;

public class Food {
    private final String name;
    private final Date expiryDate;
    private final Date createDate;
    private double price;
    private final double discount;

    public Food(String name, Date expiryDate, Date createDate, int price, double discount) {
        this.name = name;
        this.expiryDate = expiryDate;
        this.createDate = createDate;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice() {
        int expiryDays = expiryDate.getDate() - createDate.getDate();
        int percentage = Calendar.getInstance().getTime().getDate() - createDate.getDate();
        if ((double) percentage / expiryDays > 0.75) {
            price = price * (1 - discount);
        }
    }

    public double getDiscount() {
        return discount;
    }
}
