package isp.menu;

import gc.ConsoleInput;
import java.util.List;

public class TODOApp {
    private static final ActionDelegate STUB_ACTION = null;

    private static void menuShow(List<ActionApp> actions) {
        System.out.println("\nПрограмма для построения и вывода списка задач пользователя");
        System.out.println("Что вы хотите сделать?");
        for (int i = 0; i < actions.size(); i++) {
            System.out.println(i + "." + actions.get(i).getName());
        }
    }

    private static boolean validateInput(int number, List<ActionApp> actionApps) {
        return number < 0 || number >= actionApps.size();
    }

    public static void main(String[] args) {
        ConsoleInput input = new ConsoleInput();
        Menu menu = new SimpleMenu();
        var run = true;
        var actions = List.of(new AddAction(input, menu, STUB_ACTION), new PrintAction(menu), new ExitAction());
        while (run) {
            menuShow(actions);
            int inputNumber = input.askInt("Выберите пункт меню: ");
            if (validateInput(inputNumber, actions)) {
                System.out.println("Такого пункта нет!");
            } else {
                run = actions.get(inputNumber).toDoAction();
            }
        }
    }
}
