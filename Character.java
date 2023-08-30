
/**
 * Write a description of class Character here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Character
{
    // instance variables - replace the example below with your own
    private double x;
    private double y;

    /**
     * Constructor for objects of class Character
     */
    public Character()
    {
        // initialise instance variables
        x = 500;
        y = 350;
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
}
