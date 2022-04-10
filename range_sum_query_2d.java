class NumMatrix {

    int [][] matrix ;
    int numRows ;
    int numCols ;
    
    public NumMatrix(int[][] matrix) {
        
        numRows = matrix.length ;
        numCols = matrix[0].length ;
        this.matrix = new int[numRows][numCols] ;
        
        for ( int i = 0  ; i < numRows ; i++ ) {
            
            for ( int j = 0 ; j < numCols ; j++ ) {
                this.matrix[i][j] = matrix[i][j] ;
            }
        }
    }
    
    private boolean checkCoords( int x, int y ) {
        
        return ( x >= 0 && x < numRows && y >= 0 && y < numCols ) ;
        
    }
    
    public void update(int row, int col, int val) {
        if ( checkCoords(row,col)) this.matrix[row][col] = val ;
        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        
        int sum = 0 ;
        for ( int i = row1 ; i <= row2 ; i++ ) {
            
            for ( int j = col1 ; j <= col2 ; j++ )
                sum += matrix[i][j] ;
        }
        
        return sum ;
    }
    
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */
