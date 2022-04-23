class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        
        int startPointer = 0 ;
        int lastPointer = 0 ;
        int indexSecondChar = 0 ;
        
        HashSet<Character> charSet = new HashSet<Character>() ;
        int longestString = 0 ;
        
        while ( lastPointer < s.length() ) {
            
            if ( !charSet.contains(s.charAt(lastPointer)) && charSet.isEmpty() ) {
                
                charSet.add(s.charAt(lastPointer)) ;
                
            }
            
            else if ( !charSet.contains(s.charAt(lastPointer)) && charSet.size() == 2 ) {
                
                longestString = Math.max( longestString, (lastPointer-startPointer) ) ;
                System.out.println(s.substring(startPointer,lastPointer)) ;
                charSet.clear() ;
                charSet.add(s.charAt(lastPointer)) ;
                startPointer = lastPointer-1 ;
                while ( s.charAt(startPointer) == s.charAt(startPointer-1)) startPointer-- ;
                
                charSet.add(s.charAt(startPointer)) ;
                
            }
            
            else if ( !charSet.contains(s.charAt(lastPointer)) && charSet.size() == 1 ) {
                
                indexSecondChar = lastPointer ;
                charSet.add(s.charAt(lastPointer)) ;
                
            }
            
            ++lastPointer ;
        }
        
        System.out.println(s.substring(startPointer,lastPointer)) ;
        return Math.max(longestString, (lastPointer-startPointer)) ;
        
    }
}
