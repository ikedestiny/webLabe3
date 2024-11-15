package controller;

import database.ResultService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.bean.ManagedBean;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Data;
import model.Result;
import utils.ResultChecker;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@Named("results")
@ApplicationScoped
@Data
public class ResultsController {
    private double x;
    private double y;
    private double r;
    private Timestamp reqTime;
    @Inject
    private ResultService service;

    public void setX(double x) {
        this.x = x;
    }



    private ArrayList<Result> clickedResult = new ArrayList<>();


    public List<Result> getAll() throws SQLException {
        return  service.getAll();
    }

    public void addClick() throws SQLException {
        clickedResult.add(ResultChecker.check(new Result(getX(), getY(), getR(), Timestamp.valueOf(LocalDateTime.now()), "0", false)));
        saveResult();

    }


    //TODO method to add to db
    public void saveResult() throws SQLException {
        setReqTime();
        Result result = new Result(getX(), getY(), getR(), reqTime, "not set", false);
        service.save(ResultChecker.check(result));
    }

    public void setReqTime() {
        this.reqTime = new Timestamp(System.currentTimeMillis());
    }
}
