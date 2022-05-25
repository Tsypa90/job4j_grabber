package cache;

import java.util.Scanner;

public class Emulator {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String file = insertDir();
        DirFileCache dirFileCache = new DirFileCache(file);
        while (true) {
            System.out.printf("Что вы хотите сделать? %n"
                    + "1. загрузить в КЭШ?%n"
                    + "2. достать из КЭША?%n"
                    + "3. Exit%n");
            int whatDo = scanner.nextInt();
            if (whatDo == 1) {
                dirFileCache.put(file, dirFileCache.load(file));
                System.out.println("Файл загружен!");
            } else if (whatDo == 2) {
                if (dirFileCache.cache.get(file) == null) {
                    System.out.println("КЭШ пуст");
                } else {
                    System.out.println(dirFileCache.load(file));
                }
            } else {
                System.out.println("Спасибо!");
                break;
            }
        }
    }

    private static String insertDir() {
        System.out.print("Укажите путь к файлу: ");
        return scanner.nextLine();
    }
}
