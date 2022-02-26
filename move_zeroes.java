class Solution {
    public void moveZeroes(int[] nums) {
        
        int count_non_zero = 0 ;
        int count_zero = 0 ;
        
        for ( int i = 0 ; i < nums.length ; i++ ) {
            if ( nums[i] != 0 ) nums[count_non_zero++] = nums[i] ;
            else count_zero++ ;
        }
        
        for ( int j = count_non_zero ; j < nums.length ; j++ ) {
            nums[j] = 0 ;
        }
    }
}
