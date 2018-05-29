package com.robot.wars.model;

/**
 * Created by baynescorps on 29/05/2018.
 */
public class Coordinate {

    private Integer x;
    private Integer y;

    public Coordinate(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinate that = (Coordinate) o;

        if (x != null ? !x.equals(that.x) : that.x != null) return false;
        return !(y != null ? !y.equals(that.y) : that.y != null);

    }

    @Override
    public int hashCode() {
        int result = x != null ? x.hashCode() : 0;
        result = 31 * result + (y != null ? y.hashCode() : 0);
        return result;
    }
}
