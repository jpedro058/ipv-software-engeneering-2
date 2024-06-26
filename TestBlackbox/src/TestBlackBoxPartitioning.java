import com.es2.blackboxpartitioning.ArrayUtils;
import com.es2.blackboxpartitioning.Die;
import com.es2.blackboxpartitioning.End;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TestBlackBoxPartitioning {
    private final static ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        System.setOut(new PrintStream(outContent));
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
        System.setOut(System.out);
        new End();
    }

    @BeforeEach
    void setUp() throws Exception {
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @Test
    void testDieConstructor() {
        Die d = new Die();
        assertEquals(6, d.getNumSides());
        assertEquals(1, d.getResult());
    }

    @Test
    void testDieConstructor1Parameter() {
        Die d = new Die(4);
        assertEquals(4, d.getNumSides());
        assertEquals(1, d.getResult());
        assertThrows(AssertionError.class, ()->{
            Die d2 = new Die(1);
        });
        assertThrows(AssertionError.class, ()->{
            Die d3 = new Die(7);
        });
    }

    @Test
    void testDieConstructor2Parameters() {
        Die d = new Die(4,2);
        assertEquals(4, d.getNumSides());
        assertEquals(2, d.getResult());
        assertThrows(AssertionError.class, ()->{
            Die d2 = new Die(4,5);
        });
        assertThrows(AssertionError.class, ()->{
            Die d2 = new Die(4,0);
        });
    }

    @Test
    void testDieRoll() {
        Die d = new Die(2);
        for(int i =0 ;i< 10000;i++) {
            d.roll();
            assertTrue(d.getResult()>=1 && d.getResult()<=6);
        }
        d = new Die(6);
        for(int i =0 ;i< 10000;i++) {
            d.roll();
            assertTrue(d.getResult()>=1 && d.getResult()<=6);
        }
    }

    @Test
    void testDieToString() {
        Die d = new Die(2,1);
        assertEquals("Num sides 2 result 1", d.toString());
    }

    @Test
    void testArrayUtilsFindMin() {
        int[] lst = new int[20];
        for(int i =0; i< 20; i++) lst[i] = 20-i;
        assertEquals(19, ArrayUtils.findMin(lst));
        int[] lst2 = new int[0];
        assertThrows(AssertionError.class, ()->{
            ArrayUtils.findMin(lst2);
        });
    }

    @Test
    void testArrayUtilsResize() {
        int[] lst = new int[20];
        for(int i =0; i< 5; i++) lst[i] = 20-i;
        assertThrows(AssertionError.class, ()->{
            ArrayUtils.goodResize(lst,-1);
        });
        assertTrue(Arrays.equals(new int[]{20,19}, ArrayUtils.goodResize(lst,2)));
        assertTrue(ArrayUtils.goodResize(lst,22).length == 22);
    }


    @Test
    void testFindAndPrintPairs() {
        int[] lst = new int[20];
        for(int i =0; i< 20; i++) lst[i] = i;
        ArrayUtils.findAndPrintPairs(lst, 1);
        assertTrue(outContent.toString().contains("The two elements at indices 0 and 1 are 0 and 1 add up to 1"));
        outContent.reset();
        ArrayUtils.findAndPrintPairs(new int[0], 1);
        assertTrue(outContent.toString().equals(""));
        outContent.reset();
        assertThrows(AssertionError.class, ()->{
            ArrayUtils.findAndPrintPairs(lst, 0);
        });
    }

    @Test
    void testShowList() {
        int[] lst = new int[20];
        for(int i =0; i< 20; i++) lst[i] = i;
        ArrayUtils.showList(lst);
        assertTrue(outContent.toString().contains("0 1 2 3 4 5"));
        outContent.reset();
        ArrayUtils.showList(new int[0]);
        assertTrue(outContent.toString().equals(""));
        assertThrows(AssertionError.class, ()->{
            ArrayUtils.findAndPrintPairs(lst, 0);
        });
    }

    @Test
    void testBubbleSort() {
        int[] lst = new int[20];
        for(int i =0; i< 20; i++) lst[i] = 20-i;
        ArrayUtils.bubblesort(lst);
    }


    @Test
    void testIsAscending() {
        int[] lst = new int[2];
        lst[0]= 1;
        lst[1]= 2;
        assertTrue(ArrayUtils.isAscending(lst));
        assertTrue(ArrayUtils.isAscending(new int[0]));
        lst[0]= 2;
        lst[1]= 1;
        assertFalse(ArrayUtils.isAscending(lst));
    }
}
