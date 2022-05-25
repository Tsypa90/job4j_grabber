package cache;

import java.io.IOException;
import java.util.Scanner;

public class Emulator {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        System.out.print("Укажите директорию к файлу: ");
        String dir = scanner.next();
        DirFileCache dirFileCache = new DirFileCache(dir);
        while (true) {
            System.out.printf("Что вы хотите сделать? %n"
                    + "1. загрузить в КЭШ?%n"
                    + "2. достать из КЭША?%n"
                    + "3. Exit%n");
            int whatDo = scanner.nextInt();
            if (whatDo == 1) {
                String path = insertFile();
                dirFileCache.put(path, dirFileCache.load(path));
                System.out.println("Файл загружен!");
            } else if (whatDo == 2) {
                String path = insertFile();
                if (dirFileCache.get(path) == null) {
                    System.out.println("КЭШ пуст");
                } else {
                    System.out.println(dirFileCache.load(path));
                }
            } else {
                System.out.println("Спасибо!");
                break;
            }
        }
    }

    private static String insertFile() {
        System.out.print("Укажите имя файла: ");
        return scanner.next();
    }
}
