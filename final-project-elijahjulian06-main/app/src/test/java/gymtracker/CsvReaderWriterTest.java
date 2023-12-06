package gymtracker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList; 

/** CsvReaderWriterTest
 * 
 * test for the CsvReaderWriter class
 * 
 */
public class CsvReaderWriterTest
{
    private CsvReaderWriter reader;
    private final String FILENAME = "../app/src/test/java/resources/testFile.csv";
    ArrayList<String> testList;


    public final String PRINTSET = "Date: 11/12/23 Workout: BenchPress" + "\n" 
                                 + "Set: 0 Weight: 185.0" + "\n"
                                 + "Set: 1 Weight: 195.0" + "\n" 
                                 + "Set: 2 Weight: 205.0" + "\n"
                                 + "Set: 3 Weight: 225.0" + "\n"
                                 + "Set: 4 Weight: 250.0" + "\n";

    @BeforeEach
    public void beforeEach() throws FileNotFoundException
    {
        reader = new CsvReaderWriter();
        testList = reader.readCSV(FILENAME);
    }

    @Test
    public void testReadCsv() 
    {
        assertEquals("11/12/23", testList.get(0));
        assertEquals("BenchPress", testList.get(1));
        assertEquals("5", testList.get(2));
        assertEquals("10", testList.get(3));
        assertEquals("30", testList.get(4));
        assertEquals("185", testList.get(5));
        assertEquals("195", testList.get(6));
        assertEquals("205", testList.get(7));
        assertEquals("225", testList.get(8));
        assertEquals("250", testList.get(9));
    }

    @Test
    public void testBuildType()
    {
        Lift bp = reader.buildType(testList);
        assertTrue(bp instanceof BenchPress);
        assertEquals(PRINTSET, bp.printSet());
    }





}
