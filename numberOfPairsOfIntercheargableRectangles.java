class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        
        HashMap<Double, Long> countRatios = new HashMap<>() ;
        
        for ( int i = 0 ; i < rectangles.length ; i++ ) {
            
            Double ratio = (double)rectangles[i][0]/(double)rectangles[i][1] ;
            
            if ( countRatios.get(ratio) == null ) countRatios.put(ratio,1L) ;
            else countRatios.put( ratio, countRatios.get(ratio)+1L) ;
            
        }
        
        long total_count = 0 ;
        for ( Double d : countRatios.keySet() ) {
            
            if ( countRatios.get(d) > 1 ) 
            total_count += (long) (countRatios.get(d)*(countRatios.get(d)-1))/2 ;
            
        }
        
        return total_count ;
    }
}
