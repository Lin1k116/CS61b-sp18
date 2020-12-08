import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    static OffByOne cc = new OffByOne();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        //isPalindrome test 1
        boolean b11 = palindrome.isPalindrome("");
        boolean b12 = palindrome.isPalindrome("a");
        boolean b13 = palindrome.isPalindrome("racecar");
        boolean b14 = palindrome.isPalindrome("afk");
        boolean b15 = palindrome.isPalindrome("aa");
        boolean b16 = palindrome.isPalindrome("ab");
        assertTrue(b11);
        assertTrue(b12);
        assertTrue(b13);
        assertFalse(b14);
        assertTrue(b15);
        assertFalse(b16);
        //isPalindrome test 2
        boolean b21 = palindrome.isPalindrome("", cc);
        boolean b22 = palindrome.isPalindrome("a", cc);
        boolean b23 = palindrome.isPalindrome("xqpy", cc);
        boolean b24 = palindrome.isPalindrome("xqpz", cc);
        boolean b25 = palindrome.isPalindrome("xrpy", cc);
        boolean b26 = palindrome.isPalindrome("hkvji", cc);
        boolean b27 = palindrome.isPalindrome("hkvjj", cc);
        boolean b28 = palindrome.isPalindrome("hkvii", cc);
        boolean b29 = palindrome.isPalindrome("adehilmkjgfcb", cc);
        assertTrue(b21);
        assertTrue(b22);
        assertTrue(b23);
        assertFalse(b24);
        assertFalse(b25);
        assertTrue(b26);
        assertFalse(b27);
        assertFalse(b28);
        assertTrue(b29);
    }
}
