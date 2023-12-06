package gymtracker;

/** Visitor 
 * 
 * Interface forvisitor classes.
 * 
 */
public interface Visitor
{
    public void visit(BenchPress bp);
    public void visit(DeadLift dl);
    public void visit(Squat s);
    public void visit(NullLift nl);
    public void visit(Accesory a);

}
