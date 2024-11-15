import database.DatabaseConnector;
import database.ResultService;
import model.Result;

import javax.imageio.plugins.tiff.TIFFImageReadParam;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Properties;

public class TestClass {
    public static void main(String[] args) {
        Properties properties = new Properties();
        try (InputStream input = new FileInputStream("src/main/java/database/db.properties")) {
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

            ResultService service  = new ResultService();
            System.out.println(service.getAll());
           // service.save(new Result(1,1,1, Timestamp.valueOf(LocalDateTime.now()),"124",true));
            System.out.println(System.getenv("USER-NAME"));
            System.out.println(Math.abs(Duration.between(Timestamp.valueOf(LocalDateTime.now()).toInstant(), Timestamp.valueOf("2024-11-14 20:21:21").toInstant()).getNano()));
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
