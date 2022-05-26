package cache;

import gc.ConsoleInput;
import java.io.IOException;
import java.nio.file.NoSuchFileException;

public class Emulator {

    public static void main(String[] args) throws IOException, NoSuchFileException {
        ConsoleInput consoleInput = new ConsoleInput();
        String dir = consoleInput.askStr("Укажите директорию к файлу: ");
        DirFileCache dirFileCache = new DirFileCache(dir);
        while (true) {
            String question = "Что вы хотите сделать? %n"
                    + "1. загрузить в КЭШ?%n"
                    + "2. достать из КЭША?%n"
                    + "3. Exit%n";
            int whatDo = validInt(question, consoleInput);
            if (whatDo == 1) {
                boolean invalid = true;
                do {
                    String path = consoleInput.askStr("Укажите имя файла: ");
                    dirFileCache.put(path, dirFileCache.load(path));
                    invalid = false;
                } while (invalid);
                System.out.println("Файл загружен!");
            } else if (whatDo == 2) {
                String path = consoleInput.askStr("Укажите имя файла: ");
                if (dirFileCache.get(path) == null) {
                    System.out.println("КЭШ пуст");
                } else {
                    System.out.println(dirFileCache.load(path));
                }
            } else if (whatDo == 3) {
                System.out.println("Спасибо!");
                break;
            } else {
                System.out.println("Выберите правильный пункт меню!");
            }
        }
    }

    public static int validInt(String question, ConsoleInput consoleInput) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = consoleInput.askInt(question);
                invalid = false;
            } catch (NumberFormatException ime) {
                System.out.println("Введите правильное значение!");
            }
        } while (invalid);
        return value;
    }
}
