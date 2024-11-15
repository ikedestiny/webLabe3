package dev.destiny.lab3webnetbeansversion;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestClass {
    public static void main(String[] args) {
        Properties properties = new Properties();
        try (InputStream input = new FileInputStream("src/main/java/dev/destiny/lab3webnetbeansversion/db/db.properties")) {
            properties.load(input);

            // Get properties
            String dbUrl = properties.getProperty("db.url");
            String dbUser = properties.getProperty("db.username");
            String dbPassword = properties.getProperty("db.password");
            String appName = properties.getProperty("application.name");

            // Print properties
            System.out.println("Database URL: " + dbUrl);
            System.out.println("Database User: " + dbUser);
            System.out.println("Database Password: " + dbPassword);
            System.out.println("Application Name: " + appName);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
