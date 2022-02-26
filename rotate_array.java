class Solution {
  
  //Solution with additional space
    public void rotate(int[] nums, int k) {
        
        int move = k % nums.length ;
        int[] copy = new int[nums.length] ;
        for ( int i = 0 ; i < nums.length ; i++ ) {
            copy[i] = nums[i] ;
        }
        
        for ( int i = 0 ; i < nums.length ; i++ ) {
            if ( i+move < nums.length ) nums[i+move] = copy[i] ;
            else nums[(i+move)%nums.length] = copy[i] ;
        }
    }
}
