 /**
 * Creates an integer that can be manipulated. This was needed becuase the 
 * normal int was not allowed to be used in a lambda expression.
 *
 * @author: Ryan Wong
 * @version 1.0
 */

public class Integ
{
    // instance variables - replace the example below with your own
    int s;
    /**
     * Constructs an integer with an intial value of 0.
     */
    public Integ()
    {
        s = 0;
    }
    
    /**
     * Constructs an integer with an intial value that the user gives.
     */
    public Integ(int n) {
        s = n;
    }
    
    /**
     * Sets the score to the new score.
     * @param int newS
     */
    public void setValue(int newS) {
        s = newS;
    }
    
    /**
     * Returns the value of the integer.
     * @return int s
     */
    public int getValue() {
        return s;
    }
    
    public void changeValue(int n) {
        s += n;
    }
}