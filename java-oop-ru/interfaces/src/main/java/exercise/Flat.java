package exercise;

// BEGIN
public class Flat implements Home {
    @Override
    public double getArea() {
        return area + balconyArea;
    }

    @Override
    public int compareTo(Home another) {
// Для сравнения двух значений типа double по их относительной близости друг к другу нужен метод compare()
        return Double.compare(this.getArea(), another.getArea());
    }

    double area;
    double balconyArea;
    int floor;

    public Flat(double area, double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }

    public String toString() {
        return "Квартира площадью " + getArea() + " метров на " + floor + " этаже";
    }
}
// END
