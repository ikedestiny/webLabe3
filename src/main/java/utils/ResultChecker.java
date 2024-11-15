package utils;

import jakarta.inject.Inject;
import model.Result;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;

public class ResultChecker {

    public static Result check(Result result){
        boolean res =  isInCurve(result) || isInRectangle(result) || isInTriangle(result);
        result.setInArea(res);
        Duration execTime =  Duration.between(result.getRecieved().toInstant(), Timestamp.valueOf(LocalDateTime.now()).toInstant());
        result.setExecutionTime(String.valueOf(Math.abs(execTime.getNano())));
        return result;
    }


    public static boolean isInCurve(Result result){
        if (!(result.getX() >= 0 && result.getY() <= 0)) {
            return false;
        }
        return new Point(result.getX(), result.getY()).radiusToCenter() <= result.getR();
    }

    public static boolean isInTriangle(Result result){
        if (!(result.getX() <= 0 && result.getY() <= 0)) {
            return false;
        }
        Point checkPoint = new Point(result.getX(), result.getY());
        Point center = new Point(0, 0);
        Point Ox = new Point(-result.getR() / 2, 0);
        Point Oy = new Point(0, -result.getR());

        Triangle main = new Triangle(center, Ox, Oy);
        Triangle t1 = new Triangle(center, Ox, checkPoint);
        Triangle t2 = new Triangle(center, Oy, checkPoint);
        Triangle t3 = new Triangle(Oy, Ox, checkPoint);

        return main.area() == t1.area() + t2.area() + t3.area();
    }

    public static  boolean isInRectangle(Result result){
        return result.getY() <= result.getR() && -result.getX()<= result.getR();
    }


}
