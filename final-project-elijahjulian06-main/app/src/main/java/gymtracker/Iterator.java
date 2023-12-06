package gymtracker;

/**
 * interface for iterator
 */
public interface Iterator 
{
    public Lift next();
    public boolean hasNext();
    public Lift getCurrent();    
}
