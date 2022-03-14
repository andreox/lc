class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        
        int k = indices.length ;
        HashMap<Integer,Integer> indices_map = new HashMap<Integer,Integer>() ;
        for ( int i = 0 ; i < k ; i++ ) {
            indices_map.put(indices[i],i) ;
        }
        
        int j = 0 ;
        StringBuilder str_build = new StringBuilder() ;
        while ( j < s.length() ) {
            if ( indices_map.get(j) != null ) {
                
                int index = indices_map.get(j) ;
                
                boolean check = checkIfStrEquals(s, sources[index], j) ;
                if ( check ) {
                    str_build.append(targets[index]) ;
                    j += sources[index].length() ;
                }
                else {
                    str_build.append(s.charAt(j++)) ; 
                }
            }
            else { str_build.append(s.charAt(j++)) ;}
            
        }
        System.out.println(str_build.toString()) ;
        return str_build.toString() ;
    }
    
    public boolean checkIfStrEquals(String s1, String s2, int start) {
        
        boolean equal = true ;
        
        int j = 0 ;
        for ( int i = start ; i <= (start+s2.length()-1) && i < s1.length() ; i++ ) {
            if (s1.charAt(i) != s2.charAt(j) ) equal = false ;
            j++ ;
        } 
        //more check on s1.length
        return equal ;
        
    }
}
