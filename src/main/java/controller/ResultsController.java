package controller;

import database.ResultService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpServletRequest;
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

    private ArrayList<Result> clickedResult = new ArrayList<>();

    public void setX(double x) {
        this.x = x;
    }








    public List<Result> getAll() throws SQLException {
        return  service.getAll();
    }

    public void addClick(double x, double y) throws SQLException {
        setX(x);
        setY(y);
        clickedResult.add(ResultChecker.check(new Result(x, y, getR(), Timestamp.valueOf(LocalDateTime.now()), "0", false)));
        saveResult();

    }

    public void UpdateParamsXY(){
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        setX(Double.parseDouble(request.getParameter("clickedX")));
        setY(Double.parseDouble(request.getParameter("clickedY")));
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
