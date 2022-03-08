//Solves almost all test cases

class Solution {
    
    private int longestPath = 1 ;
    
    public int longestIncreasingPath(int[][] matrix) {
        
        
        int m = matrix.length ;
        int n = matrix[0].length ;
        
        for ( int i = 0 ; i < m ; i++ ) {
            for ( int j = 0 ; j < n ; j++ ) {
                System.out.println("longestPath : "+dfs(matrix,i,j,m,n)+ " i , j : "+i+ " "+j) ;
            }
        }
        
        return longestPath ;
        
    }
    
    public int dfs(int[][] matrix, int i, int j, int m, int n) {
        
        if ( hasNoGreaterNeighbours(matrix, i, j, m, n) ) return 1 ;
        
        int curr_max = 0 ;
        
        int min = Integer.MAX_VALUE ;
        
        int next_i = 0 ;
        int next_j = 0 ;
        
        ArrayList<Pair<Integer,Integer>> min_values = findMinValues(matrix,i,j,m,n) ;
        
        for ( Pair<Integer,Integer> p : min_values ) {
            int curr_i = p.getKey() ;
            int curr_j = p.getValue() ;
            int val = dfs(matrix,curr_i,curr_j,m,n) + 1 ;
            curr_max = Math.max(curr_max,val) ;
            
        }
        
        longestPath = Math.max( longestPath, curr_max ) ;
        
        return curr_max ;
    }
    
    public boolean hasNoGreaterNeighbours( int[][] matrix, int i, int j, int m, int n) {
        
        if ( (i-1) >= 0 && matrix[i-1][j] > matrix[i][j] ) return false ;
        if ( (i+1) < m && matrix[i+1][j] > matrix[i][j] ) return false ;
        if ( (j+1) < n && matrix[i][j+1] > matrix[i][j] ) return false ;
        if ( (j-1) >= 0 && matrix[i][j-1] > matrix[i][j] ) return false ;
        
        return true ;
    }
    
    public ArrayList<Pair<Integer,Integer>> findMinValues(int [][] matrix, int i, int j, int m, int n) {
        
        ArrayList<Pair<Integer,Integer>> min_values = new ArrayList<>() ;
        int min_val = Integer.MAX_VALUE ;
        int next_i = 0 ;
        int next_j = 0 ;
        
        if ( (i-1) >= 0 && matrix[i-1][j] > matrix[i][j] && matrix[i-1][j] < min_val ) {
            min_val = matrix[i-1][j] ; 
            next_i = i-1 ; 
            next_j = j ; 
            Pair<Integer,Integer> min = new Pair(next_i,next_j) ;
            min_values.clear() ;
            min_values.add(min) ;
        }
        
        else if ( (i-1) >= 0 && matrix[i-1][j] > matrix[i][j] && matrix[i-1][j] == min_val ) {
            min_val = matrix[i-1][j] ; 
            next_i = i-1 ; 
            next_j = j ; 
            Pair<Integer,Integer> min = new Pair(next_i,next_j) ;
            min_values.add(min) ;
        }
        
        if ( (i+1) < m && matrix[i+1][j] > matrix[i][j] && matrix[i+1][j] < min_val ) {
            min_val = matrix[i+1][j] ; 
            next_i = i+1 ;
            next_j = j ; 
            Pair<Integer,Integer> min = new Pair(next_i,next_j) ;
            min_values.clear() ;
            min_values.add(min) ;
        }
        
        else if ( (i+1) < m && matrix[i+1][j] > matrix[i][j] && matrix[i+1][j] == min_val ) {
            min_val = matrix[i+1][j] ; 
            next_i = i+1 ;
            next_j = j ; 
            Pair<Integer,Integer> min = new Pair(next_i,next_j) ;
            min_values.add(min) ;
        }
        
        if ( (j+1) < n && matrix[i][j+1] > matrix[i][j] && matrix[i][j+1] < min_val ) {
            min_val = matrix[i][j+1] ; 
            next_i = i ; 
            next_j = j+1 ; 
            Pair<Integer,Integer> min = new Pair(next_i,next_j) ;
            min_values.clear() ;
            min_values.add(min) ;
        }
        
        else if ( (j+1) < n && matrix[i][j+1] > matrix[i][j] && matrix[i][j+1] == min_val ) {
            min_val = matrix[i][j+1] ; 
            next_i = i ; 
            next_j = j+1 ; 
            Pair<Integer,Integer> min = new Pair(next_i,next_j) ;
            min_values.add(min) ;
        }
        
        if ( (j-1) >= 0 && matrix[i][j-1] > matrix[i][j] && matrix[i][j-1] < min_val ) {
            min_val = matrix[i][j-1] ; 
            next_i = i; 
            next_j = j-1 ; 
            Pair<Integer,Integer> min = new Pair(next_i,next_j) ;
            min_values.clear() ;
            min_values.add(min) ;
        }
        
        else if ( (j-1) >= 0 && matrix[i][j-1] > matrix[i][j] && matrix[i][j-1] == min_val ) {
            min_val = matrix[i][j-1] ; 
            next_i = i; 
            next_j = j-1 ; 
            Pair<Integer,Integer> min = new Pair(next_i,next_j) ;
            min_values.add(min) ;
        }
        
        return min_values ;
    }
    
}
