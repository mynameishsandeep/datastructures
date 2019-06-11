public class MergeSort {
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
        Comparable[] aux = new Comparable[arr.length];
        Sort(arr,aux, 0, arr.length - 1);
    }

    public static void Sort(Comparable[] arr,Comparable[] aux, int low, int high){
        if (low < high){
            int middle = (low + high ) / 2;
            Sort(arr,aux,low, middle);
            Sort(arr,aux,middle + 1, high);
            merge(arr, aux, low, middle, high);
        }
    }

    private static void merge(Comparable[] arr,Comparable[] aux, int low, int middle, int high){
        for(int i = low; i < high + 1; i ++)
            aux[i] = arr[i];

        int i = low;
        int j = middle + 1;
        int count = low;
        for (int m = low; m <= high; m ++){

            if (i == middle + 1)
                arr[m] = aux[j++];
            else if (j == high + 1)
                arr[m] = aux[i ++];
            else if (less(aux[i], aux[j]))
                arr[m] = aux[i++];
            else
                arr[m] = aux[j++];

        }
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
