package database;

import lombok.AllArgsConstructor;
import lombok.Data;
import model.Result;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Data
public class ResultService {

    DatabaseConnector connector = new DatabaseConnector("postgres","Macdestiny65@","jdbc:postgresql://localhost:5432/weblab3");

    public ResultService() {
    }

    public void save(Result result) throws SQLException {
        Connection connection = connector.connect();
        createResultTable();
        PreparedStatement saveResult = connection.prepareStatement(Queries.ADD_RESULT);
        saveResult.setDouble(1,result.getX());
        saveResult.setDouble(2,result.getY());
        saveResult.setDouble(3,result.getR());
        saveResult.setBoolean(4, result.isInArea());
        saveResult.setTimestamp(5,result.getRecieved());
        saveResult.setString(6, result.getExecutionTime());
        saveResult.executeUpdate();//for this command query must be ddl add del update etc
        saveResult.close();
        connection.commit();
        connection.close();
        getAll();

    }


    public void createResultTable() throws SQLException {
        Connection connection = connector.connect();
        PreparedStatement statement = connection.prepareStatement(Queries.CREATE_RESULTS_TABLE);
        statement.executeUpdate();
        statement.close();
        connection.commit();
        connection.close();
        System.out.println("successfully connected database");
    }



    public List<Result> getAll() throws SQLException {
        Connection connection = connector.connect();
        List<Result> results = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement(Queries.GET_ALL_RESULTS);
        ResultSet resultSet = statement.executeQuery();
        connection.commit();
        while(resultSet.next()){
           // Result result = extract(resultSet);
            results.add(extract(resultSet));
        }
        statement.close();
        connection.close();
        return results;
    }

    private Result extract(ResultSet resultSet) throws SQLException {
        return  new Result(resultSet.getDouble("x"), resultSet.getDouble("y"), resultSet.getDouble("r"),resultSet.getTimestamp("received"), resultSet.getString("executionTime"), resultSet.getBoolean("inarea"));
    }
}
