package lsp.shop;

import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ControllQualityTest {

    @Test
    public void whenShopAdd() {
        Meat meat = new Meat("pork", LocalDate.now().plusDays(15), LocalDate.now().minusDays(6), 50, 0.25);
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        List<Store> stores = List.of(warehouse, shop, trash);
        ControllQuality controllQuality = new ControllQuality(stores);
        controllQuality.control(meat);
        assertThat(shop.getStore(), is(List.of(meat)));
    }
    @Test
    public void whenTrashAdd() {
        Fruit fruit = new Fruit("apple", LocalDate.now().minusDays(1), LocalDate.now().minusDays(10), 25, 0.2);
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        List<Store> stores = List.of(warehouse, shop, trash);
        ControllQuality controllQuality = new ControllQuality(stores);
        controllQuality.control(fruit);
        assertThat(trash.getStore(), is(List.of(fruit)));
    }
    @Test
    public void whenPriceChanged() {
        Bread bread = new Bread("bread", LocalDate.now().plusDays(1), LocalDate.now().minusDays(5), 30, 0.3);
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        List<Store> stores = List.of(warehouse, shop, trash);
        ControllQuality controllQuality = new ControllQuality(stores);
        controllQuality.control(bread);
        assertThat(shop.getStore().iterator().next().getPrice(), is(21.00));
    }
    @Test
    public void whenInEqualsOut() {
        Milk milk = new Milk("milk", LocalDate.now().plusDays(20), LocalDate.now().minusDays(5), 50, 0.25);
        Meat meat = new Meat("pork", LocalDate.now().plusDays(15), LocalDate.now().minusDays(6), 50, 0.25);
        Fruit fruit = new Fruit("apple", LocalDate.now().minusDays(1), LocalDate.now().minusDays(10), 25, 0.2);
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        List<Store> stores = List.of(warehouse, shop, trash);
        ControllQuality controllQuality = new ControllQuality(stores);
        controllQuality.control(milk);
        controllQuality.control(meat);
        controllQuality.control(fruit);
        List<Food> foods = new ArrayList<>();
        foods.addAll(warehouse.getStore());
        foods.addAll(shop.getStore());
        foods.addAll(trash.getStore());
        assertThat(foods, is(List.of(milk, meat, fruit)));
    }
}