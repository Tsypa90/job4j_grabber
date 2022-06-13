package dip;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class PasswordGenerate {
    private String password;
    private Scanner scanner = new Scanner(System.in);
    private static Connection connection;
    private Properties properties;

    public String consoleInput() {
        System.out.println("Введите пароль!");
        password = scanner.nextLine();
        return password;
    }

    public void dbConnect() throws ClassNotFoundException, SQLException {
        Class.forName(properties.getProperty("driver_class"));
        String url = properties.getProperty("url");
        String login = properties.getProperty("username");
        String password = properties.getProperty("password");
        connection = DriverManager.getConnection(url, login, password);
    }
}
