package exercise;

// BEGIN
class Circle {
    private int radius;

    Point point;

    Circle(Point point, int radius) {
        this.point = point;
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public double getSquare() throws NegativeRadiusException {
        if (radius < 0) {
            throw new NegativeRadiusException("Отрицательный радиус");
        }
        return Math.PI * radius * radius;
    }
}
// END
