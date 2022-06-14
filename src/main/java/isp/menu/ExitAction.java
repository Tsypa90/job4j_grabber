package isp.menu;

public class ExitAction implements ActionApp {
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
