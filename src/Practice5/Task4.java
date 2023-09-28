package Practice5;

public class Task4 {
    public static void main(String[] args) {
        MovablePoint point = new MovablePoint(2,1,1,1);
        getInfo(point);
        MovableCircle circle = new MovableCircle(4,2,1,1,3);
        getInfo(circle);
    }

    public static void getInfo(Movable object) {
        System.out.println(object);
        object.moveRight();
        System.out.println(object);
        object.moveUp();
        System.out.println(object);
        object.moveLeft();
        System.out.println(object);
        object.moveDown();
        System.out.println(object);
    }
}

interface Movable {
    void moveUp();
    void moveDown();
    void moveLeft();
    void moveRight();
}

class MovablePoint implements Movable {
    int x;
    int y;
    int xSpeed;
    int ySpeed;

    public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public String toString() {
        return "Точка - Координата x: " + x + ", Координата y: " + y + ", Скорость V(x): "
                + xSpeed + ", Скорость V(y): " + ySpeed;
    }

    public void moveUp() {
        y += ySpeed;
    }

    public void moveDown() {
        y -= ySpeed;
    }

    public void moveLeft() {
        x -= xSpeed;
    }

    public void moveRight() {
        x += xSpeed;
    }
}

class MovableCircle implements Movable {
    private int radius;
    private MovablePoint center = new MovablePoint(0,0,0,0);

    public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius) {
        center.x = x;
        center.y = y;
        center.xSpeed = xSpeed;
        center.ySpeed = ySpeed;
        this.radius = radius;
    }

    public String toString() {
        return "Окружность - Координата x: " + center.x + ", Координата y: " + center.y + ", Скорость V(x): "
                + center.xSpeed + ", Скорость V(y): " + center.ySpeed + ", Радиус: " + radius;
    }


    public void moveUp() {
        center.y += center.ySpeed;
    }

    public void moveDown() {
        center.y -= center.ySpeed;
    }

    public void moveLeft() {
        center.x -= center.xSpeed;
    }

    public void moveRight() {
        center.y += center.ySpeed;
    }
}
