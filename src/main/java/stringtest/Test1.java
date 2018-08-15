package stringtest;

/** @Author: shuyizhi @Date: 2018-08-15 10:15 @Description: */
public class Test1 {
    public static void main(String[] args) throws ClassNotFoundException {
        // region 内部类
        // Circle circle = new Circle(20);
        // circle.printCircle();
        /// ** 创建成员内部类的方式 */
        // Circle.Draw draw1 = circle.new Draw();
        //
        // Circle.Draw draw = circle.getDraw();
        // draw.drawShape(30);
        // endregion

        // region 局部内部类
        // Man man = new Man();
        // People woman = man.getWoman();
        // endregion

        // region 局部内部类和匿名内部类只能访问局部final变量
        // new Test1().test(20);
        new Test1().testFinalVariable(20);
        // endregion
    }

    public void test(int b) {
        int a = 10;
        new Thread(
                        new Runnable() {
                            @Override
                            public void run() {
                                System.out.println("a: " + a);
                                System.out.println("b: " + b);
                            }
                        })
                .start();
    }

    public void testFinalVariable(final int b) {
        final int a = 10;
        new Thread(
                        () -> {
                            System.out.println("a: " + a);
                            System.out.println("b: " + b);
                        })
                .start();
    }
}

/** 成员内部类 */
class Circle {
    double radius = 0;

    public Circle(double radius) {
        this.radius = radius;
    }

    public Draw getDraw() {
        return new Draw();
    }

    public void printCircle() {
        System.out.println("print Circle: " + this.radius);
    }

    class Draw {
        double radius = 0;

        public void drawShape(double radius) {
            this.radius = radius;
            System.out.println("drawshape");
            System.out.println("radius: " + radius);
            System.out.println("outter class radius: " + Circle.this.radius);
        }
    }
}

/** 局部内部类 */
class People {
    public People() {
        System.out.println("people constructor");
    }
}

class Man {
    public Man() {
        System.out.println("man constructor");
    }

    /**
     * 局部内部类
     *
     * @return
     */
    public People getWoman() {
        class Woman extends People {
            int age = 0;

            Woman() {}

            Woman(int age) {
                this.age = age;
            }

            public void printInfo() {
                System.out.println("局部内部类woman: " + Woman.class.getName());
            }
        }
        return new Woman();
    }
}

// class Shape {
//    protected String name;
//
//    // public Shape() {
//    //    name = "shape";
//    // }
//
//    public Shape(String name) {
//        this.name = name;
//    }
// }
//
// class Circle extends Shape {
//    private double radius;
//
//    public Circle() {
//        super("circle");
//        radius = 0;
//    }
//
//    public Circle(double radius) {
//        super("circle");
//        this.radius = radius;
//    }
//
//    public Circle(double radius, String name) {
//        super("circle");
//        this.radius = radius;
//        this.name = name;
//    }
// }

//
// class Bread {
//    // static {
//    //    System.out.println("Bread is loaded");
//    // }
//
//    public Bread() {
//        System.out.println("bread Constructor");
//    }
// }
//
// class Meal {
//    public Meal() {
//        System.out.println("meal Constructor");
//    }
//
//    Bread bread = new Bread();
// }
