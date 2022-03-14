class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        if (nums.length == 1 && nums[0] == target ) {
            return new int[]{0,0} ;
        }
        
        int start = 0 ;
        int end = nums.length -1 ;
        int med = 0 ;
        boolean tr = false ;
        while ( !tr && start <= end ) {
            med = (end+start)/2 ;
            if ( nums[med] == target) tr = true ;
            else if ( nums[med] > target )
                end = med-1 ;
            else
                start = med+1 ;
            
        }
        
        if ( !tr ) return new int[]{-1,-1} ;
        
        int i = med ;
        int j = med ;
        while ( i >= 0 && nums[i] == target ) i-- ;
        while ( j < nums.length && nums[j] == target ) j++ ;
        
        return new int[]{i+1,j-1} ;
        
    }
}
