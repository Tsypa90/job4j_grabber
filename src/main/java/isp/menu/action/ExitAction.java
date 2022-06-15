package isp.menu.action;

public class ExitAction implements AppAction {
    public static final String NAME = "Завершить работу.";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public boolean toDoAction() {
        System.out.println("Досвидания!");
        return false;
    }
}
