package isp.menu;

public class TODOApp {
    private static final ActionDelegate STUB_ACTION = null;

    public static void main(String[] args) {
        Menu menu = new SimpleMenu();
        menu.add(Menu.ROOT, "Сходить в магазин", STUB_ACTION);
//        menu.add(Menu.ROOT, "Покормить собаку", STUB_ACTION);
        menu.add("Сходить в магазин", "Купить продукты", STUB_ACTION);
        menu.add("Купить продукты", "Купить хлеб", STUB_ACTION);
//        menu.add("Купить продукты", "Купить молоко", STUB_ACTION);
        new SimpleMenuPrinter().print(menu);
    }
}
