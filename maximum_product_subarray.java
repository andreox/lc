//beats almost all test cases, not right, lc solution is much more elegant and short.

class Solution {
    public int maxProduct(int[] nums) {
        
        if ( nums.length == 1 ) return nums[0] ;
        int start = 0 ;
        int end = 0 ;
        int max_product = Integer.MIN_VALUE ;
        for ( int i = 0 ; i < nums.length ; i++ ) {
            if ( nums[i] == 0 ) {
                max_product = Math.max(max_product,0) ;
                int count = countNegatives(nums,start,end) ;
                int max = 0 ;
                if ( count == (end-start+1)) {
                    max = maxInSubInterval(nums,start,end,true) ;
                }
                else {
                    max = maxInSubInterval(nums,start,end,false) ;
                }
                max_product = Math.max(max_product, max) ;
                if ( i < nums.length-1 ) {
                    start = i+1 ;
                    end = i+1 ;
                }
            }
            
            else end++ ;
            
        }
        //compute last, case in which there isn't any final zero
        int count = countNegatives(nums,start,end) ;
        int max = 0 ;
        if ( count == (end-start+1) ) {
                max = maxInSubInterval(nums,start,end,true) ;
        }
        else {
                max = maxInSubInterval(nums,start,end,false) ;
        }
        max_product = Math.max(max_product, max) ;
        
        return max_product ;
    }
    
    public int maxInSubInterval(int [] nums, int start, int end, boolean module) {
        
        if ( end-start == 0 ) return nums[end] ;
        
        int prev = nums[end-1] ;
        if ( prev < 0 && module ) prev *= -1 ;
        int max = prev ;
        
        for ( int i = end-2 ; i >= start ; i-- ) {
            int curr = nums[i] ;
            if ( module && curr < 0 ) curr *= -1 ;
            if ( curr*prev > curr ) {
                max = Math.max(max, curr*prev) ;
                prev *= curr ;
            }
            else if ( curr*nums[i+1] > curr ) {
                max=Math.max(max,curr*nums[i+1]) ;
                prev = curr*nums[i+1] ;
            }
            else {
                prev = curr ;
                max = Math.max(max, curr) ;
            }
            
        }
        
        return max ;
    }
    
    public int countNegatives(int[] nums, int start, int end ) {
        int count = 0 ;
        int n = nums.length ;
        while ( start <= end && start < n ) {
            if (nums[start]<0) count++ ;
            start++ ;
        }
        return count ;
    }
}

//divide et impera based on zeroes.ff
//if number of negatives is even, can i treat their modules? yes --> NO!
