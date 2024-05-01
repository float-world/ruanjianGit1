import java.util.Scanner;
abstract class Shape {
    public abstract double calculatePerimeter();
    public abstract double calculateArea();

    public String comparePerimeter(Shape otherShape) {
        double thisPerimeter = this.calculatePerimeter();
        double otherPerimeter = otherShape.calculatePerimeter();

        if (thisPerimeter > otherPerimeter) {
            return "大于";
        } else if (thisPerimeter < otherPerimeter) {
            return "小于";
        } else {
            return "等于";
        }
    }

    public String compareArea(Shape otherShape) {
        double thisArea = this.calculateArea();
        double otherArea = otherShape.calculateArea();

        if (thisArea > otherArea) {
            return "大于";
        } else if (thisArea < otherArea) {
            return "小于";
        } else {
            return "等于";
        }
    }
}

// Triangle class
class Triangle extends Shape {
    private double side1;
    private double side2;
    private double side3;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    @Override
    public double calculatePerimeter() {
        return side1 + side2 + side3;
    }

    @Override
    public double calculateArea() {
        // Implement formula for area calculation (e.g., using Heron's formula)
        double p = calculatePerimeter() / 2;
        return Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
    }

    @Override
    public String toString() {
        return "Triangle - Perimeter: " + calculatePerimeter() + ", Area: " + calculateArea();
    }
}

// Rectangle class
class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (length + width);
    }

    @Override
    public double calculateArea() {
        return length * width;
    }

    @Override
    public String toString() {
        return "Rectangle - Perimeter: " + calculatePerimeter() + ", Area: " + calculateArea();
    }
}

// Circle class
class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "Circle - Perimeter: " + calculatePerimeter() + ", Area: " + calculateArea();
    }
}


// Example usage:
public class Main {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        boolean k=true;

        while(k)
        {
            System.out.println("******请输入所比较的类型******");
            System.out.println("******1.Triangle vs Rectangle******");
            System.out.println("******2.Triangle vs Cricle******");
            System.out.println("******3.Rectangle vs Cricle******");
            System.out.println("******4.exit******");
            int choice=scan.nextInt();

            switch(choice)
            {
                case 1:
                    double a,b,c,d,e;
                System.out.println("请输入三角形的三边");
                a=scan.nextDouble();
                b=scan.nextDouble();
                c=scan.nextDouble();
                if(a+b<=c||a+c<=b||b+c<=a){
                    System.out.println("输入的三条边不满足构成三角形的条件");
                    break;
                }
                System.out.println("请输入矩形的两边");
                d=scan.nextDouble();
                e=scan.nextDouble();
                Triangle triangle = new Triangle(a, b, c);
                Rectangle rectangle = new Rectangle(d,e);
                System.out.println(triangle);
                System.out.println(rectangle);
                System.out.println("Comparison of perimeter: Triangle vs Rectangle: " + triangle.comparePerimeter(rectangle));
                System.out.println("Comparison of area: Triangle vs Rectangle: " + triangle.compareArea(rectangle));
                break;

                case 2:
                    double a1,b1,c1,r;
                    System.out.println("请输入三角形的三边");
                    a1=scan.nextDouble();
                    b1=scan.nextDouble();
                    c1=scan.nextDouble();
                    if(a1+b1<=c1||a1+c1<=b1||b1+c1<=a1){
                        System.out.println("输入的三条边不满足构成三角形的条件");
                        break;
                    }
                    System.out.println("请输入圆的半径");
                    r=scan.nextDouble();

                    Triangle triangle1 = new Triangle(a1, b1, c1);
                    Circle circle = new Circle(r);
                    System.out.println(triangle1);
                    System.out.println(circle);
                    System.out.println("Comparison of perimeter: Triangle vs Circle: " + triangle1.comparePerimeter(circle));
                    System.out.println("Comparison of area: Triangle vs Circle: " + triangle1.compareArea(circle));
                    break;

                    case 3:
                        double a2,b2,r2;
                        System.out.println("请输入矩形的两边");
                        a2=scan.nextDouble();
                        b2=scan.nextDouble();
                        System.out.println("请输入圆的半径");
                        r2=scan.nextDouble();
                        Rectangle rectangle2 = new Rectangle(a2,b2);
                        Circle circle2 = new Circle(r2);
                        System.out.println(rectangle2);
                        System.out.println(circle2);
                        System.out.println("Comparison of perimeter: Rectangle vs Circle: " + rectangle2.comparePerimeter(circle2));
                        System.out.println("Comparison of area: Rectangle vs Circle: " + rectangle2.compareArea(circle2));
                        break;

                case 4:
                    k=false;
                    break;


            }


        }

    }
}