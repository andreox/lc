class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        //sliding window problem, O(n) solution
        if ( s.length() == 0 ) return 0 ;
        else if ( s.length() == 1 ) return 1 ;
        
        int first_index = 0 ;
        int second_index = 0 ;
        int substring_dim = 0 ;
        int temp_dim = 0 ;
        HashMap<Character,Integer> seen_chars = new HashMap<Character,Integer>() ;
        while ( second_index < s.length() ) {
            
            if ( seen_chars.containsKey(s.charAt(second_index))) {
                
                int last_it = seen_chars.get(s.charAt(second_index)) ;
                for ( int i = first_index ; i <= last_it ; i++) {
                    seen_chars.remove(s.charAt(i)) ;
                }
                first_index = last_it+1 ;
                
            
            }
            
            else {
                seen_chars.put(s.charAt(second_index),second_index) ;
                second_index++ ;
            }
            
            temp_dim = (second_index-first_index) ;
            if ( temp_dim > substring_dim ) substring_dim = temp_dim ;
            
        }
        
        return substring_dim ;
    }
}
