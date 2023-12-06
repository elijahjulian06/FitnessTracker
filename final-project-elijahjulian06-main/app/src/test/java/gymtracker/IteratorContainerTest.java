package gymtracker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/** IteratorContainerTest
 * 
 * test test the iterator and container pattern.
 * 
 */
public class IteratorContainerTest 
{
    private Lift head;
    private Lift middle;
    private Lift tail;

    private FowardContainer forwardContainer;
    private ForwardIterator forwardIterator;

    @BeforeEach
    public void beforeEach()
    {
        head = mock(Lift.class);
        middle = mock(Lift.class);
        tail = mock(Lift.class);
        
        forwardContainer = new FowardContainer();
        forwardIterator = (ForwardIterator) forwardContainer.getIterator(head);
    }

    @Test
    public void testHasNext()
    {
        when(head.getNextLift()).thenReturn(middle);
        when(middle.getNextLift()).thenReturn(tail);

        assertTrue(forwardIterator.hasNext());
        forwardIterator.next();
        assertTrue(forwardIterator.hasNext());
        forwardIterator.next();
        assertFalse(forwardIterator.hasNext());;
        
    }

    /**
     * test next() and getCurrent()
     * 
     */
    @Test 
    public void testNextGetCurrent()
    {
        when(head.getNextLift()).thenReturn(middle);
        when(middle.getNextLift()).thenReturn(tail);

        assertEquals(head, forwardIterator.getCurrent());
        forwardIterator.next();
        assertEquals(middle, forwardIterator.getCurrent());
        forwardIterator.next();
        assertEquals(tail, forwardIterator.getCurrent());

    }

    /** testAddNextLift
     * 
     * mocks make it the container act funky so i just implemented a full example
     */
    @Test
    public void testAddNextLift()
    {   
        Lift head2 = new BenchPress(null,null,0,0,0); 
        Lift middle2 = new DeadLift(null,null,0,0,0); 
        Lift tail2 = new Squat(null,null,0,0,0); 

        FowardContainer forwardContainer2 = new FowardContainer();
        ForwardIterator forwardIterator2 = (ForwardIterator) forwardContainer.getIterator(head2);

        forwardContainer2.addNextLift(head2);
        forwardContainer2.addNextLift(middle2);
        forwardContainer2.addNextLift(tail2);

        assertEquals(head2, forwardIterator2.getCurrent());
        forwardIterator2.next();
        assertEquals(middle2, forwardIterator2.getCurrent());
        forwardIterator2.next();
        assertEquals(tail2, forwardIterator2.getCurrent());

    }

    
}
