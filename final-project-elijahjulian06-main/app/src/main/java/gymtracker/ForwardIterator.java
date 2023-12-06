package gymtracker;

public class ForwardIterator implements Iterator
{
    

    private Lift current;
    private Lift head;

    /** FowardIterator 
     * 
     * @param current - used to set the head of list.
     * 
     */
    public ForwardIterator(Lift current)
    {
        this.current = current;
        this.head = current;
    }

    /**
     * 
     * sets the current lift to the next lift.
     * 
     */
    @Override
    public Lift next()
    {
        if(hasNext())
        {
            current = current.getNextLift();
        }
        return null;
    }

    /**
     * 
     * checks to see if there is a next lift.
     * 
     */
    @Override
    public boolean hasNext() 
    {
        return (current.getNextLift() != null);
    }

    /**
     * 
     * returns the current lift.
     * 
     */
    @Override
    public Lift getCurrent() 
    {
        return current;
    }

    public void reset()
    {
        current = head;
    }
    
}
