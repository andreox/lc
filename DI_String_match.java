class Solution {
    public int[] diStringMatch(String s) {
        
        int [] perm = new int[s.length()+1] ;
        
        int max_num = s.length() ;
        int min_num = 0 ;
        
        int i = 0 ;
        for ( ; i < s.length() ; i++ ) {
            if ( s.charAt(i) == 'I' ) perm[i] = min_num++ ;
            else perm[i] = max_num-- ;
        }
        
        if ( s.charAt(i-1) == 'D') perm[i] = min_num ;
        else perm[i] = max_num ;
        
        return perm ;
    }
}
