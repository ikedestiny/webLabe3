package utils;

public record Point(double x, double y) {

    public double  radiusToCenter(){
        return  Math.sqrt(Math.pow(x(),2)+Math.pow(y(),2));
    }
}
