
public class LinkedListDeque<T> implements Deque<T> {
    /**创建节点类**/
    private class IntNode {
        private IntNode prev;
        private T item;
        private IntNode next;

        private IntNode(T i, IntNode n, IntNode p) {
            prev = p;
            item = i;
            next = n;
        }
    }

    private IntNode sentinel;
    private int size;

    /**创建空链表**/
    public LinkedListDeque() {
        sentinel = new IntNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

//    /**other复制**/
//    public LinkedListDeque(LinkedListDeque<T> other) {
//        sentinel = new IntNode(null, null, null);
//        sentinel.next = sentinel;
//        sentinel.prev = sentinel;
//        size = 0;
//        for (int i = 0; i < other.size(); i += 1) {
//            addLast(other.get(i));
//        }
//    }

    /**Adds an item of type to the front of the deque**/
    @Override
    public void addFirst(T item) {
        sentinel.next = new IntNode(item, sentinel.next, sentinel);
        sentinel.next.next.prev = sentinel.next;
        size += 1;
    }

    /**Adds an item of type to the back of the deque**/
    @Override
    public void addLast(T item) {
        sentinel.prev = new IntNode(item, sentinel, sentinel.prev);
        sentinel.prev.prev.next = sentinel.prev;
        size += 1;
    }

    /**Returns true if deque is empty, false otherwise**/
    @Override
    public boolean isEmpty() {
        return (sentinel == sentinel.next);
    }

    /**Returns the number of items in the deque**/
    @Override
    public int size() {
        return size;
    }

    /**Prints the items in the deque from first to last, separatedby a space.
     * Once all the items have been printed, print out a new line.**/
    @Override
    public void printDeque() {
        IntNode p = sentinel;
        while (p.next != sentinel) {
            System.out.print(p.next.item + " ");
            p = p.next;
        }
        System.out.println();
    }

    /**Removes and returns the item at the front of the deque.
     * If no such item exists, returns null.
     */
    @Override
    public T removeFirst() {
        if (sentinel.next == sentinel) {
            return null;
        }
        T r = sentinel.next.item;
        sentinel.next  = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size -= 1;
        return r;
    }

    /**Removes and returns the item at the back of the deque.
     * If no such item exists, returns null.
     *
     */
    @Override
    public T removeLast() {
        if (sentinel.next == sentinel) {
            return null;
        }
        T r = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size -= 1;
        return r;
    }

    /**Gets the item at the given index**/
    @Override
    public T get(int index) {
        if (index >= size) {
            return null;
        }
        IntNode p = sentinel;
        while (index != 0) {
            p = p.next;
            index -= 1;
        }
        return p.next.item;
    }

    /**Same as get, but uses recursion**/
    private T getRe1(IntNode n, int i) {
        if (i == 0) {
            return n.next.item;
        }
        return getRe1(n.next, i - 1);
    }

    public T getRecursive(int index) {
        if (index >= size) {
            return null;
        }
        IntNode p = sentinel;
        return getRe1(p, index);
    }
}
