package org.example.model;

public record Point(float x, float y) {

    public float  radiusToCenter(){
        return (float) Math.sqrt(Math.pow(x(),2)+Math.pow(y(),2));
    }
}
