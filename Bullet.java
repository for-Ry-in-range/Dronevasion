public class Bullet
{
    private double x;
    private double y;

    public Bullet()
    {
        x = 0;
        y = 0;
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
