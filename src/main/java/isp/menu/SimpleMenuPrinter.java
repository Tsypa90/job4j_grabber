package isp.menu;

public class SimpleMenuPrinter implements MenuPrinter {
    private static final String SPACE = "    ";

    @Override
    public void print(Menu menu) {
        menu.forEach(menuItemInfo -> {
            String indent = SPACE.repeat(menuItemInfo.getNumber().split("\\.").length - 1);
            System.out.println(indent + menuItemInfo.getNumber() + menuItemInfo.getName());
        });
    }
}
