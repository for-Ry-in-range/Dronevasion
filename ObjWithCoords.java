public class ObjWithCoords
{
    // instance variables - replace the example below with your own
    private double x;
    private double y;

    /**
     * Constructor for objects of class ObjWithCoords
     */
    public ObjWithCoords()
    {
        // initialise instance variables
        x = 0;
        y = 0;
    }
    /**
     * Constuctor with x and y coordinates given
     */
    public ObjWithCoords(double x_param, double y_param)
    {
        // initialise instance variables
        x = x_param;
        y = y_param;
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
