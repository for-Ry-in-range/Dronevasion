public class Enemy
{
    // instance variables - replace the example below with your own
    private double x;
    private double y;
    private int num;

    /**
     * Constructor for objects of class Enemy
     */
    public Enemy(int n)
    {
        // initialise instance variables
        x = 1000;
        y = 1400;
        num = n;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setY(double newY) {
        y = newY;
    }

    public void setX(double newX) {
        x = newX;
    }
    
    public void changeY(double newY) {
        y += newY;
    }

    public void changeX(double newX) {
        x += newX;
    }
    
    public int identity() {
        return num;
    }
}
