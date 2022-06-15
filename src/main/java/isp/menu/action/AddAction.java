package isp.menu.action;

import gc.ConsoleInput;
import isp.menu.ActionDelegate;
import isp.menu.Menu;

public class AddAction implements AppAction {
    public static final String NAME = "Добавить задачу.";
    private ConsoleInput input;
    private Menu menu;
    private ActionDelegate delegate;

    public AddAction(ConsoleInput input, Menu menu, ActionDelegate delegate) {
        this.input = input;
        this.menu = menu;
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public boolean toDoAction() {
        var ln = System.lineSeparator();
        var task = input.askStr(ln + "Введите задачу: ");
        var taskDir = input.askInt("Куда добавить задачу?" + ln + "В корень или нет? Выберите 1 или 2: ");
        if (taskDir == 1) {
            if (menu.add(Menu.ROOT, task, delegate)) {
                System.out.println("Задача добавлена!");
            } else {
                System.out.println("Что-то пошло не так!");
            }
        } else if (taskDir == 2) {
            var dir = input.askStr("В какую категорию добавить задачу?" + ln + "Введите имя задачи: ");
            if (menu.add(dir, task, delegate)) {
                System.out.println("Задача добавлена!");
            } else {
                System.out.println("Что-то пошло не так!");
            }
        } else {
            System.out.println("Такого пункта нет!");
        }
        return true;
    }
}
