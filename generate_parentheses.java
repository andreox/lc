class Solution {
    
    ArrayList<String> permutations_list ;
    int i ;
    int len_str ;
    public List<String> generateParenthesis(int n) {
        
        i = 0 ;
        len_str = n*2;
        permutations_list = new ArrayList<String>() ;
        findAllDistinctPaths(permutations_list,new StringBuilder(),n-1,n,false) ;
        
        return permutations_list ;
        
    }
    
    public void findAllDistinctPaths(List<String> answer, StringBuilder cur_string, int remainingOpen, int remainingClose, boolean isClose ) {
        
        
        if ( (remainingClose < remainingOpen) || remainingOpen < 0 ) return ;
        
        if ( isClose ) cur_string.append(")") ;
        else cur_string.append("(") ;
        i++ ;
        if ( cur_string.length() == len_str ) {
            answer.add(cur_string.toString()) ;
            
        }
        
        findAllDistinctPaths(permutations_list,cur_string,remainingOpen-1,remainingClose,false) ;        
        findAllDistinctPaths(permutations_list,cur_string,remainingOpen,remainingClose-1,true) ;
        cur_string.deleteCharAt(cur_string.length()-1) ;
        
    }
    
}

//finally working solution. O(2^(2n-0.5))
