class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> parent_stack = new Stack<Character>() ;
        
        for ( int i = 0 ; i < s.length() ; i++ ) {
            if ( isOpening(s.charAt(i))) {
                parent_stack.push(s.charAt(i)) ;
                
            }
            
            else {
                
                if ( parent_stack.empty() ) return false ;
                char last_parent = parent_stack.pop() ;
                if ( !parenthesisMatch(last_parent, s.charAt(i))) return false ;
            }
        }
        
        return (parent_stack.empty()) ;
    }
    
    public boolean isOpening( char c ) {
        if ( c == '{' || c == '[' || c == '(') return true ;
        return false ;
    }
    
    public boolean isClosing( char c ) {
        
        if ( c == '}' || c == ']' || c == ')') return true ;
        return false ;
    }
    
    public boolean parenthesisMatch( char open, char close ) {
        if ( open == '(' && close == ')') return true ;
        else if ( open == '[' && close == ']') return true ;
        else if  ( open == '{' && close == '}') return true ;
        return false ;
    }
}
