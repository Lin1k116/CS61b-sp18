import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import static org.junit.Assert.*;

public class TestOffByN {

    static CharacterComparator offByN = new OffByN(5);

    @Test
    public void testOffByN() {
        assertTrue(offByN.equalChars('a', 'f'));
        assertTrue(offByN.equalChars('m', 'r'));
        assertFalse(offByN.equalChars('q', 'w'));
    }
}
