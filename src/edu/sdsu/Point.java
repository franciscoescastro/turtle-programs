package edu.sdsu;

import java.math.BigDecimal;

public class Point {
    private Double x;
    private Double y;

    public Point() {
        x = y = new Double(0);
    }

    public Point(Double x, Double y) {
        this.x = x;
        this.y = y;
    }

    public void update(Double deltaX, Double deltaY) {
        x = formatDoublePrecision(x + deltaX, 2);
        y = formatDoublePrecision(y + deltaY, 2);
    }

    private Double formatDoublePrecision(Double number, int scale) {
        BigDecimal finalNumber = new BigDecimal(number).setScale(scale,
                BigDecimal.ROUND_HALF_UP);
        return new Double(finalNumber.doubleValue());
    }

    public Double getX() {
        return x;
    }

    public Double getY() {
        return y;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Point [x=").append(x).append(", y=").append(y)
                .append("]");
        return builder.toString();
    }
}