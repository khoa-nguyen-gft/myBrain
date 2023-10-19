package org.example;

/**
 * Hello world!
 *
 */

interface Shape {
    double calculateArea();

    double calculatePerimeter();

    default void printDetails(){
        System.out.println("this is Shape");
    }

}

class Circle implements Shape {

    private double radius;

    @Override
    public double calculateArea() {

        return Math.PI + radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 + radius * radius;
    }

    public Circle(double radius) {
        this.radius = radius;
    }
}
public class App 
{
    public static void main( String[] args )
    {
        Shape shape = new Circle(5);
        System.out.println("Area: " + shape.calculateArea());
        System.out.println("Perimeter: " + shape.calculatePerimeter());
        shape.printDetails(); // This will call the default method
    }
}
