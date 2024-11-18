package controller;

import database.ResultService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.bean.ManagedBean;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Data;
import model.Result;
import utils.ResultChecker;

import java.io.Serializable;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@Named("results")
@ApplicationScoped
@Data
public class ResultsController implements Serializable {
    private double x;
    private double y;
    private double r;
    private Timestamp reqTime;
    @Inject
    private ResultService service;

    @Inject
    private ArrayList<Result> clickedResult;









    public List<Result> getAll() throws SQLException {
        return  service.getAll();
    }






    //TODO method to add to db
    public void saveResult()  {
        setReqTime();
        Result result = new Result(getX(), getY(), getR(), reqTime, "not set", false);
        try {
            service.save(ResultChecker.check(result));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void saveClick() {
        setReqTime();
        Result result = new Result(getX(), getY(), getR(), reqTime, "not set", false);
       // clickedResult.add(result);
        try {
            service.save(ResultChecker.check(result));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void clear() {
        try {
            service.removeAll();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }




    public void setReqTime() {
        this.reqTime = new Timestamp(System.currentTimeMillis());
    }
}
