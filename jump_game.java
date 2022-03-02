class Solution {
    public boolean canJump(int[] nums) {
        
        int max_jump = 0;
        int len = nums.length ;
        int i = 0 ;
        
        while ( i < len-1 ) {
            
            if ( (i+nums[i]) > max_jump ) max_jump = i+nums[i] ;
            
            if ( nums[i] == 0 && max_jump <= i ) return false ;
            i++ ;
            
        }
        
        return true ;
    }
}
