package io.codeforall.bootcamp;

public class Measures {

    public float width;
    public float lenght;
    private String type;

    public Measures(float width, float lenght) {
        this.width = width;
        this.lenght = lenght;
        this.type = "Rectangle";
    }

    public Measures(float width) {
    }

    public float Area(float number1, float number2) {
        return number1 * number2;
    }

    public float Area(float number1) {
        return number1 * number1;
    }

    public float perimeter(float number1, float number2) {
        return number1 * 2 + number2 * 2;
    }

    public float perimeter(float number1) {
        return number1 * 4;
    }

    public String tellMeYourType() {
        return this.type;
    }

    public void changeType(String newtype) {
        if (newtype.equals("Square") || newtype.equals("Rectangle")) {
            this.type = newtype;
        }
        System.out.println("Please insert a valid type");
    }
}





