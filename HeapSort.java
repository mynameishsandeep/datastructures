/**
 * Created with IntelliJ IDEA.
 * User: Gong Li
 * Date: 5/26/13
 * Time: 1:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class HeapSort {
    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5};
        for (int i = 0; i < arr.length; i ++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        Sort(arr);
        for (int i = 0; i < arr.length; i ++){
            System.out.print(arr[i]+" ");
        }
    }


    public static void Sort(Comparable[] arr){
        //Shift the original array to the right by 1 space
        Comparable[] temp = new Comparable[arr.length+1];
        for(int i = 0; i < arr.length; i ++){
            temp[i+1] = arr[i];
        }

        heapSort(temp);

        for (int i  = 0; i < arr.length; i ++)
            arr[i] = temp[i+1];
    }

    //helper methods
    private static void heapSort(Comparable[] arr){
        heapify(arr);
        for (int i = arr.length - 1; i >= 1; i --){
            exch(arr, 1, i);
            sink(arr,1, i-1);
        }
    }

    private static void heapify(Comparable[] arr){
        int size = arr.length - 1;
        for(int i = size / 2; i >= 1; i --){
            sink(arr,i, size);
        }
    }

    private static void sink(Comparable[] arr, int k,int size){
        while (2*k <= size){
            int j = 2 * k;
            if (j < size && less(arr[j+1], arr[j])) j = j + 1;
            if (less(arr[j], arr[k])) exch(arr, j,k);
            k = j;
        }
    }

    private static boolean less(Comparable m, Comparable n){
        if (m.compareTo(n) < 0)
            return true;
        return false;
    }

    private static void exch(Comparable[] arr, int m, int n){
        Comparable temp = arr[m];
        arr[m] = arr[n];
        arr[n] = temp;
    }
}
