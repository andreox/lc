class Solution {
    public int maxArea(int[] height) {
        
        int start = 0 ;
        int end = height.length - 1 ;
        int curr_max_area = 0 ;
        while ( start < end ) {
            
            int curr_area = Math.min(height[start],height[end]) * (end-start) ;
            if ( curr_area > curr_max_area ) curr_max_area = curr_area ;
            if ( height[start] <= height[end]) start++ ;
            else end-- ;
        }
        
        return curr_max_area ;
    }
}
