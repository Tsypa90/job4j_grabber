package isp.menu;

public class PrintAction implements ActionApp {
    public static final String NAME = "Вывод списка задач.";
    private Menu menu;

    public PrintAction(Menu menu) {
        this.menu = menu;
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public boolean toDoAction() {
        new SimpleMenuPrinter().print(menu);
        return true;
    }
}
