
public class LinkedListDeque<T> {
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

    /**other复制**/
    public LinkedListDeque(LinkedListDeque<T> other) {
        sentinel = new IntNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
        for (int i = 0; i < other.size(); i += 1) {
            addLast(other.get(i));
        }
    }

    /**Adds an item of type to the front of the deque**/
    public void addFirst(T item) {
        sentinel.next = new IntNode(item, sentinel.next, sentinel);
        sentinel.next.next.prev = sentinel.next;
        size += 1;
    }

    /**Adds an item of type to the back of the deque**/
    public void addLast(T item) {
        sentinel.prev = new IntNode(item, sentinel, sentinel.prev);
        sentinel.prev.prev.next = sentinel.prev;
        size += 1;
    }

    /**Returns true if deque is empty, false otherwise**/
    public boolean isEmpty() {
        return (sentinel == sentinel.next);
    }

    /**Returns the number of items in the deque**/
    public int size() {
        return size;
    }

    /**Prints the items in the deque from first to last, separatedby a space.
     * Once all the items have been printed, print out a new line.**/
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
    public T getRe1(IntNode n, int i) {
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

//    /**简单测试部分**/
//    public static void main(String[]args) {
//        LinkedListDeque t = new LinkedListDeque();
//        System.out.println("空链表判断：" + t.isEmpty());
//        t.addFirst(1);
//        t.addFirst(3);
//        t.addFirst(5);
//        t.addLast(6);
//        t.addLast(8);
//        System.out.println("大小：" + t.size());
//        System.out.println("空链表判断：" + t.isEmpty());
//        System.out.print("顺序输出：");
//        t.printDeque();
//        System.out.println("index = 3：" + t.get(3));
//        LinkedListDeque v = new LinkedListDeque(t);
//        System.out.println("去F：" + t.removeFirst());
//        System.out.println("去L：" + t.removeLast());
//        t.printDeque();
//        v.printDeque();
//        System.out.println("大小：" + t.size());
//        System.out.println("get 2:" + t.get(2));
//        System.out.println("recursive_get 2:" + t.getRecursive(2));
//    }
}
