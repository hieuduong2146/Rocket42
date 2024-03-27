package generic;

public class Circle<T extends Number & Comparable<T>>{
    private T radius;
    private String color;

    public Circle(T radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", color='" + color + '\'' +
                '}';
    }
}