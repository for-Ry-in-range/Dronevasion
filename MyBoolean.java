/**
 * Creates a boolean that can be manipulated. This was needed becuase the 
 * normal boolean was not allowed to be used in a lambda expression.
 *
 * @author: Ryan Wong
 * @version 1.0
 */

public class MyBoolean
{
    // instance variables - replace the example below with your own
    boolean b;
    
    /**
     * Constructs a boolean with an intial value of false.
     */
    public MyBoolean()
    {
        b = false;
    }
    
    public MyBoolean(boolean bool)
    {
        b = bool;
    }
    
    /**
     * Sets the score to the new boolean.
     * @param boolean bool
     */
    public void setBoolean(boolean bool) {
        b = bool;
    }
    
    /**
     * Returns the value of the boolean.
     * @reutrn boolean b
    */
    public boolean getValue() {
        return b;
    }
}
