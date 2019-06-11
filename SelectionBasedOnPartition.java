public class SelectionBasedOnPartition {

    public static void main(String[] args) {
        Integer[] arr = {2,3,1,5,4};
        for (int i = 0; i < arr.length; i ++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();

        System.out.println(findKthEle(arr,4));
        System.out.println(findKthEle(arr,3));
        System.out.println(findKthEle(arr,2));
        System.out.println(findKthEle(arr,1));
        System.out.println(findKthEle(arr,0));

    }

    public static Comparable findKthEle(Comparable[] arr, int k){
        int low = 0;
        int high = arr.length - 1;

        while (low < high){
            int index = partition(arr, low, high);
            if (index == k) return arr[k];
            else if(index > k) high = index - 1;
            else    low = index + 1;
        }

        return arr[k];
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
