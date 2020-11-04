public class ArrayDeque {
    int[] x;
    int size;

    public ArrayDeque(){
        x = new int[8];
        size = 0;
    }

    public void resize(int capacity){
        int[] a = new int[capacity];
        System.arraycopy(x, 0, a, 0, size);
        x = a;
    }

    public void addFirst(int a) {
        if (size == x.length) {
            resize(size * 2);
        }
        for (int i = size - 1; i >= 0; i--){
            x[size + 1] = x[size];
        }
        x[size] = a;
        size ++;
    }

    public void addLast(int a) {
        if (size == x.length) {
            resize(size * 2);
        }
        x[size] = a;
        size ++;
    }

    public boolean isEmpty(){
        if(x.length == 0){
            return true;
        }
        return false;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        for (int i:x){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public int removeFirst(){
        int a = x[0];
        for (int i:x){
            x[i] = x[i + 1];
        }
        size --;
        return a;
    }

    public int getLast(){
        return x[size - 1];
    }

    public int removeLast(){
        int a = getLast();
        size --;
        return a;
    }

    public int get(int index){
        return x[0];
    }
}
