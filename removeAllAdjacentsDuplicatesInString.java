class Solution {
    
    static class CharPair {
        
        char c ;
        int count ;
        CharPair( char c, int count) {
            this.c = c ;
            this.count = count ;
        }
        
    }
    public String removeDuplicates(String s, int k) {
        
        Stack<CharPair> charsStack = new Stack<>() ;
        
        for ( int i = 0 ; i < s.length() ; i++ ) {
            
            if ( !charsStack.isEmpty() && charsStack.peek().c == s.charAt(i) && charsStack.peek().count == k-1) {
                
                while ( !charsStack.isEmpty() && charsStack.peek().c == s.charAt(i))
                    charsStack.pop() ;
                
            }
            
            else if ( !charsStack.isEmpty() && charsStack.peek().c == s.charAt(i)) {
                CharPair cp = new CharPair(s.charAt(i), charsStack.peek().count+1) ;
                charsStack.add(cp) ;
            }
            
            else /*if ( charsStack.isEmpty() )*/ {
                CharPair cp = new CharPair(s.charAt(i),1) ;
                charsStack.add(cp) ;
            }
            
        }
        StringBuilder res = new StringBuilder() ;
        while ( !charsStack.isEmpty() ) res.append(charsStack.pop().c) ;
        
        return String.valueOf(res.reverse());
        
    }
}
