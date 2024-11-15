package database;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Data
@AllArgsConstructor
public class DatabaseConnector {
    private String username;
    private String password;
    private String url;


    public Connection connect()  {

        try{
           Connection  connection = DriverManager.getConnection(getUrl(),getUsername(),getPassword());
            connection.setAutoCommit(false);
            return connection;}catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }

    }
}
