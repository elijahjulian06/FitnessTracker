package gymtracker;

public class FowardContainer implements Container 
{
    private Lift head = null;
    
    /** getIterator
     * 
     * returns a ForwardIterator - 
     * 
     */
    public Iterator getIterator(Lift curr)
    {
        return new ForwardIterator(curr);
    }

    /** addNextLift 
     * 
     * @param p - node that is added to the next list.
     */
    public void addNextLift(Lift p)
    {
        if(head == null)
        {
            head = p;
        }
        else
        {
            Lift current = head;
            while(current.getNextLift() != null)
            {
                current = current.getNextLift();
            }
            current.setNextLift(p);
        }
    }
}
