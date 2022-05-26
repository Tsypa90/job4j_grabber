package gc;

import java.util.Scanner;

public class ConsoleInput {

    private Scanner scanner = new Scanner(System.in);

    public String askStr(String question) {
        System.out.printf(question);
        return scanner.nextLine();
    }

    public int askInt(String question) {
        return Integer.parseInt(askStr(question));
    }
}
