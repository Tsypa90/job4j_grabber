package dip;

import java.util.Scanner;

public class UserMsg {
    private String msg;
    private Scanner scanner = new Scanner(System.in);
    private MsgOutput output = new MsgOutput();

    public String consoleInput() {
        System.out.println("Введите сообщение!");
        msg = scanner.nextLine();
        return msg;
    }

    public void printMsg() {
        output.consoleOutput(msg);
    }
}
