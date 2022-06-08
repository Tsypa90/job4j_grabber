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
        List<Store> stores = List.of(new Warehouse(), new Shop(), new Trash());
        ControllQuality controllQuality = new ControllQuality(stores);
        foods.forEach(controllQuality::control);
        assertThat(expected, is(stores.get(1).getStore()));
    }
    @Test
    public void whenTrashAdd() {
        Milk milk = new Milk("milk", LocalDate.now().plusDays(20), LocalDate.now().minusDays(5), 50, 0.25);
        Meat meat = new Meat("pork", LocalDate.now().plusDays(15), LocalDate.now().minusDays(6), 50, 0.25);
        Fruit fruit = new Fruit("apple", LocalDate.now().minusDays(1), LocalDate.now().minusDays(10), 25, 0.2);
        List<Food> foods = List.of(milk, meat, fruit);
        List<Food> expected = List.of(fruit);
        List<Store> stores = List.of(new Warehouse(), new Shop(), new Trash());
        ControllQuality controllQuality = new ControllQuality(stores);
        foods.forEach(controllQuality::control);
        assertThat(expected, is(stores.get(2).getStore()));
    }
    @Test
    public void whenPriceChanged() {
        Milk milk = new Milk("milk", LocalDate.now().plusDays(20), LocalDate.now().minusDays(5), 50, 0.25);
        Bread bread = new Bread("bread", LocalDate.now().plusDays(1), LocalDate.now().minusDays(5), 30, 0.3);
        Fruit fruit = new Fruit("apple", LocalDate.now().minusDays(1), LocalDate.now().minusDays(10), 25, 0.2);
        List<Food> foods = List.of(milk, bread, fruit);
        double expected = 21;
        List<Store> stores = List.of(new Warehouse(), new Shop(), new Trash());
        ControllQuality controllQuality = new ControllQuality(stores);
        foods.forEach(controllQuality::control);
        assertThat(expected, is(stores.get(1).getStore().stream().findFirst().get().getPrice()));
    }
    @Test
    public void whenInEqualsOut() {
        Milk milk = new Milk("milk", LocalDate.now().plusDays(20), LocalDate.now().minusDays(5), 50, 0.25);
        Meat meat = new Meat("pork", LocalDate.now().plusDays(15), LocalDate.now().minusDays(6), 50, 0.25);
        Fruit fruit = new Fruit("apple", LocalDate.now().minusDays(1), LocalDate.now().minusDays(10), 25, 0.2);
        List<Food> foods = List.of(milk, meat, fruit);
        List<Store> stores = List.of(new Warehouse(), new Shop(), new Trash());
        ControllQuality controllQuality = new ControllQuality(stores);
        foods.forEach(controllQuality::control);
        List<Food> expected = new ArrayList<>();
        stores.forEach(store -> expected.addAll(store.getStore()));
        assertThat(foods, is(expected));
    }
}