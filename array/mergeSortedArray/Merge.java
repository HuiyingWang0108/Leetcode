import java.util.Arrays;

public class Merge {
    public static void main(String[] args){
        Merge obj = new Merge();
        int m = 3, n = 3;
        int[] nums1 = {1, 2, 3, 0, 0, 0}, nums2 = {2,5,6};
        // nums1 = Arrays.copyOf(arr, m + n);
        System.out.println(Arrays.toString(nums1));
        obj.merge(nums1, m, nums2, n);
        
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // int i = 0, j = 0, k = 0;
        // int[] arr = new int[m + n];
        // while(m == 0){
        //     arr = nums2;
        // }
        // while(n == 0){
        //     arr = nums1;
        // }
        // while(i < m && j < n){
        //     if(nums1[i] < nums2[j]){
        //         arr[k++] = nums1[i++];
        //     }else{
        //         arr[k++] = nums2[j++];
        //     }
        // }
        // while(i < m){
        //     arr[k++] = nums1[i++];
        // }
        // while(j < n){
        //     arr[k++] = nums2[j++];
        // }
        // nums1 = arr;
        // System.out.println(Arrays.toString(nums1));
        int k = nums1.length - 1;
        m--;
        n--;
        while(m >= 0  && n >= 0){
            nums1[k--] = nums1[m] < nums2[n] ? nums2[n--]: nums1[m--];
        }
        while(n >= 0){
            nums1[k--] = nums2[n--];
        }

    }
}