class Solution {
    public int maxSubArray(int[] nums) {
        
        int[] memo_max_sum = new int[nums.length] ;
        
        memo_max_sum[nums.length-1] = nums[nums.length-1] ;
        
        for ( int j = nums.length-2 ; j >= 0 ; j-- ) {
            if ( nums[j] + memo_max_sum[j+1] > nums[j] ) memo_max_sum[j] = nums[j] + memo_max_sum[j+1] ;
            else memo_max_sum[j] = nums[j] ;
        }
        
        int max = Integer.MIN_VALUE ;
        for ( int i = 0 ; i < nums.length ; i++ ) max = Math.max(max, memo_max_sum[i]) ;
        
        return max ;
        
    }
    
}
