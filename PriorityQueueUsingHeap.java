/**
 * Created with IntelliJ IDEA.
 * User: Gong Li
 * Date: 5/26/13
 * Time: 12:23 PM
 * Implement a priority queue using a heap
 * The heap is implemented using an array indexed from 1
 */
public class PriorityQueueUsingHeap<T extends Comparable<T>> {
    T[] arr;
    int N;

    public static void main(String[] args) {
        PriorityQueueUsingHeap<Integer> pq = new PriorityQueueUsingHeap<Integer>();
        pq.insert(3);
        System.out.println(pq.toString());
        pq.insert(5);
        System.out.println(pq.toString());
        pq.insert(2);
        System.out.println(pq.toString());
        pq.insert(-1);
        System.out.println(pq.toString());
        pq.insert(9);
        System.out.println(pq.toString());
        pq.insert(4);
        System.out.println(pq.toString());

        pq.delMax();
        System.out.println(pq.toString());
        pq.delMax();
        System.out.println(pq.toString());
        pq.delMax();
        System.out.println(pq.toString());
        pq.delMax();
        System.out.println(pq.toString());
        pq.delMax();
        System.out.println(pq.toString());
    }

    public PriorityQueueUsingHeap(){
        arr = (T[]) new Comparable[2];
        N = 0;
    }

    public void insert(T t){
        if (N == arr.length - 1) resize(2*N + 1);
        arr[++N] = t;
        swim(N);
    }

    public T delMax(){
        if (isEmpty()) return null;
        T t= arr[1];
        exch(1,N--);
        arr[N+1] = null;
        sink(1);

        //resize this array
        if (N == (arr.length -1)/4) resize((arr.length-1) / 2 + 1);
        return t;
    }
    //helper methods
    public String toString(){
        StringBuffer sb = new StringBuffer();
        for(int i = 1; i <= N; i ++)
            sb.append(arr[i].toString()+" ");
        return sb.toString();
    }

    private boolean isEmpty(){
        return N == 0;
    }
    private void resize(int capacity){
        T[] copy = (T[]) new Comparable[capacity];
        for(int i = 1; i <= N; i ++ )
            copy[i] = arr[i];
        arr = copy;
    }

    private void swim(int k){
        while(k > 1 && less(k/2, k)){
            exch(k/2,k);
            k = k/2;
        }
    }

    private void sink(int k){
        while (2*k < N){
            int j = 2 * k;
            if(j < N && less(j, j +1)) j = j + 1;
            if(less(j, k)) break;
            exch(k,j);
            k = j;
        }
    }

    private boolean less(int i, int j){
        if (arr[i].compareTo(arr[j]) < 0)
            return true;
        return false;
    }

    private void exch(int i, int j){
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
