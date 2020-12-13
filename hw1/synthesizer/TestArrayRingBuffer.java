package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer arb = new ArrayRingBuffer(10);
        assertTrue(arb.isEmpty());
        assertFalse(arb.isFull());
        arb.enqueue(2);
        arb.enqueue(3);
        arb.enqueue(5);
        arb.enqueue(7);
        arb.enqueue(11);
        assertFalse(arb.isEmpty());
        assertEquals(2, arb.dequeue());
        assertEquals(3, arb.dequeue());
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
