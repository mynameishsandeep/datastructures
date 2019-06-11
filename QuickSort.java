public class QuickSort {


    public static void main(String[] args) {
        Integer[] arr = {5,4,3,2,1,-1};
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
        Sort(arr, 0, arr.length-1);
    }

    private static void Sort(Comparable[] arr, int low, int high){
        if (low < high){
            int index = partition(arr, low, high);
            Sort(arr, low, index - 1);
            Sort(arr,index+1,high);
        }
    }

    private static int partition(Comparable[] arr, int low, int high){
        int i = low;
        Comparable pivot = arr[low];
        int j = high + 1;

        while(true){
            while (less(arr[++i], pivot))
                if (i == high) break;
            while (less(pivot, arr[--j]))
                if (j == low) break;

            if (i >= j) break;

            exch(arr, i,j);
        }

        exch(arr,low, j);
        return j;
    }


    private static boolean less(Comparable v, Comparable w){
        if (v.compareTo(w) < 0)
            return true;
        return false;
    }

    private static void exch(Comparable[] a, int i, int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
