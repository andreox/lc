class Solution {
    public boolean isAnagram(String s, String t) {
        
        if ( s.length() != t.length() ) return false ;
        
        HashMap<Character,Integer> count_chars = new HashMap<Character,Integer>() ;
        
        for ( int i = 0 ; i < s.length() ; i++ ) {
            Integer count = count_chars.get(s.charAt(i)) ;
            if ( count == null ) count_chars.put(s.charAt(i),1) ;
            else count_chars.put(s.charAt(i),++count) ;
        }
        
        int j = 0 ;
        boolean wrong_char = false ;
        while ( !wrong_char && j < t.length() ) {
            Integer count = count_chars.get(t.charAt(j)) ;
            if ( count == null ) wrong_char = true ;
            else if ( count == 0 ) wrong_char = true ; //more chars
            else {
                count_chars.put(t.charAt(j),--count) ;
            }
            j++ ;
        }
        
        return !wrong_char ;
        
    }
}
