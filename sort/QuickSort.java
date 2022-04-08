import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 2, 8};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left <= right) {
            int pivot = participation(arr, left, right);
            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }
    }

    public static int participation(int[] arr, int left, int right) {
        int index = right;
        if (left == right) {
            return left;
        }
        int pivot = arr[right];
        for (int i = right - 1; i >= left; i--) {
            int currVal = arr[i];
            if (currVal > pivot) {
                // [i + 1, right] shift left: 1 <- [i + 1, right]
                int p = i + 1;
                while (p <= right) {
                    //left shift
                    arr[p - 1] = arr[p];
                    p++;
                }
                index--;
                //currVal shift to the last
                arr[right] = currVal;
            }
        }
        return index;
    }
}