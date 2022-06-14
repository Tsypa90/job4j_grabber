package isp.menu;

import gc.ConsoleInput;

public class AddAction implements ActionApp {
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
        var task = input.askStr("\nВведите задачу: ");
        var taskDir = input.askInt("Куда добавить задачу?\nВ корень или нет? Выберите 1 или 2: ");
        if (taskDir == 1) {
            if (menu.add(Menu.ROOT, task, delegate)) {
                System.out.println("Задача добавлена!");
            } else {
                System.out.println("Что-то пошло не так!");
            }
        } else if (taskDir == 2) {
            var dir = input.askStr("В какую категорию добавить задачу?\nВведите имя задачи: ");
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
