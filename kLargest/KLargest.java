import java.util.Arrays;

public class KLargest {
    public static void main(String[] args) {
        int[] arr = { 10, 2, 30, 35, 90 };
        int k = 3;
        kLargest(arr, k);
    }

    public static void kLargest(int[] arr, int k) {
        /**
         * way 1, quick sort(Arrays.sort() uses quick sort))
         * Time Complexity: O(nlog(n))
         * Space Complexity: O(1)
         */
        // Arrays.sort(arr);
        // int n = arr.length;
        // for(int i = n - 1; i >= n - k; i-- ){
        // System.out.println(arr[i]);;
        // }
        /**
         * way 2, bubble sort
         * Time Complexity: O(n * k)
         * Space Complexity: O(1)
         */
        // for (int i = 0; i < k; i++) {
        //     int bubble = arr[i];
        //     for (int j = i; j < arr.length; j++) {
        //         if (bubble < arr[j]) {
        //             int temp = bubble;
        //             bubble = arr[j];
        //             arr[j] = temp;
        //         }
        //     }
        //     System.out.println(bubble);
        // }
        /**
         * way 3, max heap
         * Time Complexity: O(klog(n))
         * Space Complexity: O(n)
         */
        int n = arr.length;
        for(int i = arr.length / 2 - 1; i >= 0; i--){//build a max heap
            heapAdjust(arr, i, arr.length);
        }
        for(int i = n - 1; i >= n - k; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapAdjust(arr, 0, i);//
            System.out.println(temp);
        }
        
    }

    private static void heapAdjust(int[] arr, int i, int n) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if(left < n && arr[left] > arr[largest]){
            largest = left;
        } 
        if(right < n && arr[right] > arr[largest]){
            largest = right;
        }
        if(largest != i){
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapAdjust(arr, largest, n);
        }
    }
}