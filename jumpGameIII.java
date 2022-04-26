class Solution {
    
    public boolean canReach(int[] arr, int start) {
    
       HashSet<Integer> indices = new HashSet<Integer>() ;
        
        if ( reach(arr,start,indices) ) return true ;
       
      return false ;
        
    }
    
    public boolean reach( int[] arr, int next_pos, HashSet<Integer> indices ) {
        
        
        if ( next_pos < 0 || next_pos >= arr.length || indices.contains(next_pos) ) return false ;
        else if ( arr[next_pos] == 0 ) return true ;
        
        if ( !indices.contains(next_pos) ) indices.add(next_pos) ;
        
        if ( reach( arr, next_pos+arr[next_pos], indices) ) return true  ;
        if ( reach( arr, next_pos-arr[next_pos], indices) ) return true  ;
        
        return false ;
        
    }
}
