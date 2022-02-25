public class Solution {
    public int[] sortedSquares(int[] nums) {
        
        int[] sorted_squares = new int[nums.length] ;
        
        //this is an insert in order problem! 
        
        int sorted_squares_size = 0 ;
        
        for ( int i = 0 ; i < nums.length ; i++ ) {
            
            int k = nums[i]*nums[i] ;
            
            int j = 0 ;
            while ( j < sorted_squares_size && k > sorted_squares[j]  ) {
                j++ ;
            }
            
            if ( sorted_squares_size < sorted_squares.length-1 ) sorted_squares_size++ ;
            
            for ( int index = sorted_squares_size ; index > j ; index-- ) {
                
                sorted_squares[index] = sorted_squares[index-1] ;
                
            }
            sorted_squares[j] = k ;

        }
        
        return sorted_squares ;
    }
}