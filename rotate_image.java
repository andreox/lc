class Solution {
    
    public void rotate(int[][] matrix) {
            
            int n = matrix[0].length ;
            HashMap< Pair<Integer,Integer>, Integer> new_positions = new HashMap<>() ;
            
            for ( int i = 0 ; i < n ; i++ ) {
                
                for ( int j = 0 ; j < n ; j++ ) {
                    
                    int new_j = n - i - 1;
                    int new_i = j ;
                    Pair<Integer,Integer> p = new Pair(new_i, new_j) ;
                    new_positions.put(p, matrix[i][j]) ;
                }
            }
            
            for ( int i = 0 ; i < n ; i++ ) {
                for ( int j = 0 ; j < n ; j++ ) {
                    
                    Pair<Integer,Integer> p = new Pair(i,j) ;
                    matrix[i][j] = new_positions.get(p) ;
                    
                }
            }
        }
}
