 /**
 * Creates a double that can be manipulated. This was needed becuase the 
 * normal double was not allowed to be used in a lambda expression.
 *
 * @author: Ryan Wong
 * @version 1.0
 */

public class Doub
{
    // instance variables - replace the example below with your own
    double s;
    /**
     * Constructs an integer with an intial value of 0.
     */
    public Doub()
    {
        s = 0.0;
    }
    
    /**
     * Sets the score to the new score.
     * @param int newS
     */
    public void setValue(double newS) {
        s = newS;
    }
    
    /**
     * Returns the value of the integer.
     * @return int s
     */
    public double getValue() {
        return s;
    }
    
    public void changeValue(double n) {
        s += n;
    }
}