class Solution {
    
    ArrayList<String> permutations_list ;
    public List<String> generateParenthesis(int n) {
        
        permutations_list = new ArrayList<String>() ;
        System.out.println(findAllDistinctPaths(n-1,n)) ;
        return new ArrayList<String>() ;
    }
    
    public int findAllDistinctPaths( int remainingOpen, int remainingClose, boolean isClose ) {
        
        if ( remainingOpen == 0 && remainingClose == 0 ) return 1 ;
        
        else if ( (remainingClose < remainingOpen) || (remainingOpen < 0 && remainingClose > 0) || (remainingOpen > 0 && remainingClose < 0) ) return 0 ;
        
        return (findAllDistinctPaths(remainingOpen-1,remainingClose)+findAllDistinctPaths(remainingOpen,remainingClose-1)) ;
        
    }
    
}
