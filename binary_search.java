class Solution {
    public int search(int[] nums, int target) {
        int first = 0 ;
        int last = nums.length - 1 ;
        
        if ( nums[first] > target || nums[last] < target ) return -1 ;
        
        while ( first <= last ) {
            int q = (first+last)/2 ;
            
            if ( nums[q] == target ) return q ;
            
            else if ( target > nums[q] ) {
                first = q+1  ;
            }
            
            else if ( target < nums[q] ) {
                last = q-1 ;
            }
            
        }
        
        return -1 ;
    }
}