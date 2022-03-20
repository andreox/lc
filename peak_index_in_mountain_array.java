class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        
        return binarySearch(arr) ;
    }
    
    public int binarySearch(int[] arr ) {
        
        int n = arr.length ;
        int start = 0 ;
        int end = n-1 ;
        int max_index = 0 ;
        while ( start <= end ) {
            int mid = start+(start-end)/2 ;
            
            if ( mid > 0 && arr[mid-1] > arr[mid] ) {
                end = mid-1 ;
            }
            else if ( mid < n && arr[mid+1] > arr[mid] ) {
                start=mid+1 ;
            }
            
            else if ( mid > 0 && mid < n && arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1] ) {
                max_index = mid ;
                break ;
            }
        }
        
        return max_index ;
    }
}
