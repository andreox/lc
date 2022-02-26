class Solution {
    public int numSplits(String s) {
        HashMap<Character,Integer> first_string = new HashMap<Character,Integer>() ;
        HashMap<Character,Integer> second_string = new HashMap<Character,Integer>() ;
        
        int i = 0 ;
        int j = 1 ;
        int count_num_splits = 0 ;
        
        //Initialize HashMaps
        first_string.put(s.charAt(i), 1) ;
        for ( ; j < s.length() ; j++) {
           if ( second_string.get(s.charAt(j)) != null ) {
               second_string.put( s.charAt(j), second_string.get(s.charAt(j))+1) ;
           }
            else second_string.put(s.charAt(j),1) ;
        }
        if ( first_string.size() == second_string.size() ) count_num_splits++ ;
        
        for ( i = 1 ; i < s.length()-1 ; i++ ) {
            
            if ( first_string.get(s.charAt(i)) != null ) {
               first_string.put( s.charAt(i), first_string.get(s.charAt(i))+1) ;
           }
            
            else first_string.put(s.charAt(i),1) ;
            
            if ( second_string.get(s.charAt(i)) == 1 ) {
                second_string.remove(s.charAt(i)) ;
            }
            else second_string.put(s.charAt(i), second_string.get(s.charAt(i))-1) ;
            
            if ( first_string.size() == second_string.size()) count_num_splits++ ;
        }
        
        return count_num_splits;
    }
}
