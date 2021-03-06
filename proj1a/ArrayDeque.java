
public class ArrayDeque<T> {
    private T[] items;
    private int nextFirst;
    private int nextLast;
    private int size;

    /**initialise the deque
     *
     */
    public ArrayDeque() {
        items = (T[]) new Object[8];
        nextFirst = 0;
        nextLast = 1;
        size = 0;
    }

    /**下一个位置索引"next"
     *
     */
    private int next(int n) {
        return (n + 1) % items.length;
    }

    /**上一个位置索引"prev"
     *
     */
    private int prev(int n) {
        return (n - 1 + items.length) % items.length;
    }

    /**resize the deque by capacity
     *
     * @param capacity
     */
    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        int toCopy = next(nextFirst);
        for (int i = 0; i < size; i += 1) {
            a[i] = items[toCopy];
            toCopy = next(toCopy);
        }
        this.items = a;
        nextFirst = this.items.length - 1;
        nextLast = size;
    }

    /**add an item of the type to the first of the deque
     *
     * @param a
     */
    public void addFirst(T a) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextFirst] = a;
        nextFirst = prev(nextFirst);
        size += 1;
    }

    /**add an item if the type to the last of the deque
     *
     * @param a
     */
    public void addLast(T a) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextLast] = a;
        nextLast = next(nextLast);
        size += 1;
    }

    /**return true if the deque is empty, false otherwise
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**return the size of the deque
     *
     * @return
     */
    public int size() {
        return size;
    }

    /**print the item in the deque form first to last
     *
     */
    public void printDeque() {
        int toPrint = next(nextFirst);
        while (items[toPrint] != null) {
            System.out.print(items[toPrint] + " ");
            toPrint = next(toPrint);
        }
        System.out.println();
    }

    /**remove and return the first item in the deque
     *
     * @return
     */
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T a = items[next(nextFirst)];
        items[next(nextFirst)] = null;
        nextFirst = next(nextFirst);
        size -= 1;
        if (items.length >= 16 && size <= (items.length / 4)) {
            resize(items.length / 2);
        }
        return a;
    }

    /**remove and return the last item in the deque
     *
     * @return
     */
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T a = items[prev(nextLast)];
        items[prev(nextLast)] = null;
        nextLast = prev(nextLast);
        size -= 1;
        if (items.length >= 16 && size <= (items.length / 4)) {
            resize(items.length / 2);
        }
        return a;
    }

    /**get the 'index'th item in the deque
     *
     */
    public T get(int index) {
        if (index > size) {
            return null;
        }
        return items[next(nextFirst + index)];
    }

//    /**testing
//     *
//     */
//    public static void main(String[] args) {
//        ArrayDeque t = new ArrayDeque();
//        System.out.println("isEmpty: " + t.isEmpty());
//        System.out.println(t.size);
//        t.addFirst(3);
//        t.addFirst(2);
//        t.addFirst(1);
//        t.addLast(4);
//        t.addLast(5);
//        t.printDeque();
//        System.out.println(t.get(0));
//        System.out.println(t.get(4));
//        System.out.println(t.get(3));
//        System.out.println("byebye");
//    }
}
