
public class Palindrome {

    public Deque<Character> wordToDeque(String word) {
        Deque<Character> deque = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i += 1) {
            deque.addLast(word.charAt(i));
        }
        return deque;
    }

    public boolean isPalindrome(String word) {
        return isPHelper(wordToDeque(word));
    }

    private boolean isPHelper(Deque<Character> deque) {
        if (deque.size() <= 1) {
            return true;
        } else if (deque.removeFirst() != deque.removeLast()) {
            return false;
        } else {
            return isPHelper(deque);
        }
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        return isPHelper(wordToDeque(word), cc);
    }

    private boolean isPHelper(Deque<Character> deque, CharacterComparator cc) {
        if (deque.size() <= 1) {
            return true;
        }
        if (!cc.equalChars(deque.removeFirst(), deque.removeLast())) {
            return false;
        }
        return isPHelper(deque, cc);
    }
}
