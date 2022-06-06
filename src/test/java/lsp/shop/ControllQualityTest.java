package lsp.shop;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ControllQualityTest {

    @Test
    public void whenShopAdd() {
        Milk milk = new Milk("milk", new Date(122, 5, 15), new Date(122, 5, 1), 50, 0.25);
        Bread bread = new Bread("bread", new Date(122, 5, 6), new Date(122, 5, 1), 30, 0.3);
        List<Food> expected = new ArrayList<>();
        expected.add(milk);
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        ControllQuality controllQuality = new ControllQuality(warehouse, shop, trash);
        controllQuality.control(milk);
        controllQuality.control(bread);
        assertThat(expected, is(shop.getStore()));
    }
    @Test
    public void whenTrashAdd() {
        Milk milk = new Milk("milk", new Date(122, 5, 15), new Date(122, 5, 1), 50, 0.25);
        Bread bread = new Bread("bread", new Date(122, 5, 6), new Date(122, 5, 1), 30, 0.3);
        List<Food> expected = new ArrayList<>();
        expected.add(bread);
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        ControllQuality controllQuality = new ControllQuality(warehouse, shop, trash);
        controllQuality.control(milk);
        controllQuality.control(bread);
        assertThat(expected, is(trash.getStore()));
    }
    @Test
    public void whenPriceChanged() {
        Milk milk = new Milk("milk", new Date(122, 5, 7), new Date(122, 5, 1), 50, 0.25);
        double expected = 37.5;
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        ControllQuality controllQuality = new ControllQuality(warehouse, shop, trash);
        controllQuality.control(milk);
        assertThat(expected, is(shop.getStore().stream().findFirst().get().getPrice()));
    }
}