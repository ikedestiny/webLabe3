package model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;
@AllArgsConstructor
@Data
public class Result {
    private double x;
    private double y;
    private double r;
    private Timestamp recieved;
    private String executionTime;
    private boolean inArea;
}
