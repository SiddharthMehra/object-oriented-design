class Circle {
    private double radius;
    private double pi;

    public Circle() {
        radius = 0;
        pi = 3.142;
    }

    public Circle(double r) {
        radius = r;
        pi = 3.142;
    }

    public double area () {
        return pi*radius*radius;
    }

    public double perimter() {
        return 2*pi*radius;
    }

    public static void main (String args[]) {
        Circle circle = new Circle(5);
        System.out.println("area " + circle.area());
        System.out.println("perimeter " + circle.perimter());
    }
}