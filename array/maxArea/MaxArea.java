public class MaxArea{
    public static void main(String[] args){}
    public int maxArea(int[] height) {
        /**
         * time complexityO(n*n)
         */
        // int max = 0;
        // int n = height.length;
        // for(int i = 0; i < n - 1; i++ ){
        //     int max_i = 0;
        //     int val_i = height[i];
        //     for(int j = i + 1; j < n; j++){
        //         int val_j = height[j];
        //         int h = Integer.min(val_i, val_j);
        //         int w = j - i;
        //         max_i = h * w;
        //         max = Integer.max(max, max_i);
        //     }
        // }
        // return max;
        /** 
         * time complexityO(n)
        */
        int max = 0;
        int l = 0, r = height.length - 1;
        while(l < r){
            int h, w = r - l;
            if(height[l] < height[r]){
                h = height[l];
                l++;
            }else{
                h = height[r];
                r--;
            }
            int area = h * w;
            max = Integer.max(max, area);
        }
        
        return max;
    }
}