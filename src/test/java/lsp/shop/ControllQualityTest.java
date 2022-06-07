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
        Milk milk = new Milk("milk", LocalDate.now().plusDays(20), LocalDate.now().minusDays(5), 50, 0.25);
        Meat meat = new Meat("pork", LocalDate.now().plusDays(15), LocalDate.now().minusDays(6), 50, 0.25);
        Fruit fruit = new Fruit("apple", LocalDate.now().minusDays(1), LocalDate.now().minusDays(10), 25, 0.2);
        List<Food> foods = List.of(milk, meat, fruit);
        List<Food> expected = List.of(meat);
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        ControllQuality controllQuality = new ControllQuality(foods);
        controllQuality.control(warehouse, shop, trash);
        assertThat(expected, is(shop.getStore()));
    }
    @Test
    public void whenTrashAdd() {
        Milk milk = new Milk("milk", LocalDate.now().plusDays(20), LocalDate.now().minusDays(5), 50, 0.25);
        Meat meat = new Meat("pork", LocalDate.now().plusDays(15), LocalDate.now().minusDays(6), 50, 0.25);
        Fruit fruit = new Fruit("apple", LocalDate.now().minusDays(1), LocalDate.now().minusDays(10), 25, 0.2);
        List<Food> foods = List.of(milk, meat, fruit);
        List<Food> expected = List.of(fruit);
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        ControllQuality controllQuality = new ControllQuality(foods);
        controllQuality.control(warehouse, shop, trash);
        assertThat(expected, is(trash.getStore()));
    }
    @Test
    public void whenPriceChanged() {
        Bread bread = new Bread("bread", LocalDate.now().plusDays(1), LocalDate.now().minusDays(5), 30, 0.3);
        Meat meat = new Meat("pork", LocalDate.now().plusDays(15), LocalDate.now().minusDays(6), 50, 0.25);
        Fruit fruit = new Fruit("apple", LocalDate.now().minusDays(1), LocalDate.now().minusDays(10), 25, 0.2);
        List<Food> foods = List.of(bread, meat, fruit);
        double expected = 21;
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        ControllQuality controllQuality = new ControllQuality(foods);
        controllQuality.control(warehouse, shop, trash);
        assertThat(expected, is(shop.getStore().stream().findFirst().get().getPrice()));
    }
    @Test
    public void whenInEqualsOut() {
        Milk milk = new Milk("milk", LocalDate.now().plusDays(20), LocalDate.now().minusDays(5), 50, 0.25);
        Meat meat = new Meat("pork", LocalDate.now().plusDays(15), LocalDate.now().minusDays(6), 50, 0.25);
        Fruit fruit = new Fruit("apple", LocalDate.now().minusDays(1), LocalDate.now().minusDays(10), 25, 0.2);
        List<Food> foods = List.of(milk, meat, fruit);
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        ControllQuality controllQuality = new ControllQuality(foods);
        controllQuality.control(warehouse, shop, trash);
        List<Food> expected = new ArrayList<>();
        expected.addAll(warehouse.getStore());
        expected.addAll(shop.getStore());
        expected.addAll(trash.getStore());
        assertThat(foods, is(expected));
    }
}