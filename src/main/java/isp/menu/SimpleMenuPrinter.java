package isp.menu;

public class SimpleMenuPrinter implements MenuPrinter {

    @Override
    public void print(Menu menu) {
        menu.forEach(menuItemInfo -> {
            StringBuilder  indent = new StringBuilder();
            for (int i = 1; i < menuItemInfo.getNumber().split("\\.").length; i++) {
                indent.append("    ");
            }
            System.out.println(indent + menuItemInfo.getNumber() + menuItemInfo.getName());
        });
    }
}
